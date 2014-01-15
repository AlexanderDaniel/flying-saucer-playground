package lachdrache;

import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.util.XRLog;

import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;

public class App {

    public static void main(String[] args) throws Exception {
        configureLogging();
        generatePdf();
    }

    private static void generatePdf() throws Exception {
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(App.class.getResource("/lachdrache/emptyListItems.html").toURI().toString());
        renderer.layout();
        renderer.createPDF(new FileOutputStream(new File("target/emptyListItems.pdf")), true);
    }

    private static void configureLogging() {
        System.getProperties().setProperty("xr.util-logging.loggingEnabled", "true");
        XRLog.setLoggingEnabled(true);
        XRLog.setLevel("", Level.WARNING);
    }

}
