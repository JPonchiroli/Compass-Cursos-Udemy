package com.pbcompass.park_api.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class JasperService {

    private static final Logger log = LoggerFactory.getLogger(JasperService.class);
    @Autowired
    private final ResourceLoader resourceLoader;
    @Autowired
    private final DataSource dataSource;


    private Map<String, Object> params = new HashMap<>();

    private static final String JASPER_DIRECTORY = "classpath:reports/";

    public void addParams(String key, Object value) {
        this.params.put("IMAGE_DIRECTORY", JASPER_DIRECTORY);
        this.params.put("REPORT_LOCALE", new Locale("pt", "BR"));
        this.params.put(key, value);
    }

    public byte[] generatePdf() {
        byte[] bytes = null;
        try {
            Resource resource = resourceLoader.getResource(JASPER_DIRECTORY.concat("parkingLot.jasper"));
            log.info(String.valueOf("RESOURCE ::: " + resource));
            InputStream stream = resource.getInputStream();
            log.info(String.valueOf("STREAM ::: " + stream));
            JasperPrint print = JasperFillManager.fillReport(stream, params, dataSource.getConnection());
            log.info(String.valueOf("PRINT ::: " + print));
            bytes = JasperExportManager.exportReportToPdf(print);
            log.info(String.valueOf("BYTES ::: " + Arrays.toString(bytes)));
        } catch (IOException e) {
            log.error("Error accessing report file: {}", e.getMessage());
            throw new RuntimeException(e);
        } catch (JRException e) {
            log.error("Jasper Reports error: {}", e.getMessage());
            throw new RuntimeException(e);
        } catch (SQLException e) {
            log.error("Database connection error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
        return bytes;
    }


}
