package lachdrache;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.util.XRLog;

import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;

public class PageSequences {

    private static final Logger logger = LoggerFactory.getLogger(PageSequences.class);

    public static void main(String[] args) throws Exception {
        configureLogging();

        logger.info("Starting PDF generation");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        generatePdf();

        stopWatch.stop();
        logger.info("PDF generation took " + stopWatch.getTime() + "ms");
    }

    private static void generatePdf() throws Exception {
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(PageSequences.class.getResource("/lachdrache/pageSequences.html").toURI().toString());
        renderer.layout();
        renderer.createPDF(new FileOutputStream(new File("target/pageSequences.pdf")), true);
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
