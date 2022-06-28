package io.github.pickdsm.pick_server_spring.domain.schedule.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import io.github.pickdsm.pick_server_spring.domain.director.domain.Director;
import io.github.pickdsm.pick_server_spring.domain.director.domain.repository.DirectorRepository;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.Schedule;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.repository.ScheduleRepository;
import io.github.pickdsm.pick_server_spring.domain.schedule.exception.InvalidFileException;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request.QueryDirectorsRequest;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryDirectorsService {

	private final ScheduleRepository scheduleRepository;
	private final DirectorRepository directorRepository;

	public void execute(QueryDirectorsRequest request, HttpServletResponse response) {
		List<Schedule> scheduleList =
				scheduleRepository.findByYearAndMonth(String.valueOf(request.getYear()), String.valueOf(request.getMonth()));
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet(String.format("PICK-%d-%d", request.getYear(), request.getMonth()));

		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue(
				String.format("PICK-%d-%d 감독정보", request.getYear(), request.getMonth()));

		Row informationRow = sheet.createRow(1);
		informationRow.createCell(0).setCellValue("날짜");
		informationRow.createCell(1).setCellValue("2층");
		informationRow.createCell(2).setCellValue("3층");
		informationRow.createCell(3).setCellValue("4층");
		informationRow.createCell(4).setCellValue("타입");

		for(Schedule schedule : scheduleList) {
			Row row = sheet.createRow(schedule.getDate().getDayOfMonth() + 1);
			row.createCell(0).setCellValue(schedule.getDate().getDayOfMonth() + "일");
			for(Director director : directorRepository.findBySchedule(schedule.getId())) {
				Cell cell = row.createCell(director.getFloor() - 1);
				cell.setCellValue(director.getTeacher().getName());
			}
			row.createCell(4).setCellValue(schedule.getName().toString());
		}

		try {
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			String formatFilename = "attachment;filename=\"" + String.format("PICK-%d-%d", request.getYear(), request.getMonth());
			String fileName = new String((formatFilename + ".xlsx\"").getBytes("KSC5601"), "8859_1");
			response.setHeader("Content-Disposition", fileName);
			workbook.write(response.getOutputStream());
			workbook.close();
		} catch (IOException e) {
			throw InvalidFileException.EXCEPTION;
		}

	}

}
