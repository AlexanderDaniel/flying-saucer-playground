package lachdrache;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.util.XRLog;

import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;

public class PdfGenerator {
    private static final Logger logger = LoggerFactory.getLogger(PdfGenerator.class);

    public static void generatePdf(String name) throws Exception {
        configureLogging();

        logger.info(String.format("Starting PDF generation for %s", name));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        renderPdf(name);

        stopWatch.stop();
        logger.info("PDF generation took " + stopWatch.getTime() + "ms");
    }

    private static void renderPdf(String name) throws Exception {
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(EmptyListItems.class.getResource(String.format("/lachdrache/%s.html", name)).toURI().toString());
        renderer.layout();
        renderer.createPDF(new FileOutputStream(new File(String.format("target/%s.pdf", name))), true);
    }

    /**
     * http://www.slf4j.org/api/org/slf4j/bridge/SLF4JBridgeHandler.html
     */
    private static void configureLogging() {
        System.getProperties().setProperty("xr.util-logging.loggingEnabled", "true");
        System.getProperties().setProperty("xr.util-logging.handlers", "org.slf4j.bridge.SLF4JBridgeHandler");
        XRLog.setLevel("", Level.INFO);
    }
}
