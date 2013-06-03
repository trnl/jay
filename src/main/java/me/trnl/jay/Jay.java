package me.trnl.jay;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.JavaPackage;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Jay {

    @Parameter(description = "sourcefiles", converter = FileConverter.class)
    private List<File> sourcefiles = new ArrayList<File>();

    @Parameter(names = "--help", help = true, description = "print this message")
    private boolean help = false;

    public static void main(final String... args) throws IOException, TemplateException {
        final Jay jay = new Jay();
        final JCommander commander = new JCommander(jay, args);
        commander.setProgramName("jay");

        if (jay.help) {
            commander.usage();
        }

        for (File f : jay.sourcefiles) {
            jay.parse(f);
        }
    }

    private void parse(final File output) throws IOException, TemplateException {
        JavaDocBuilder builder = new JavaDocBuilder();
        builder.addSourceTree(output);

        Configuration cfg = new Configuration();

        cfg.setDirectoryForTemplateLoading(new File("/code/jay/src/main/resources/templates/"));
        cfg.setObjectWrapper(new DefaultObjectWrapper());

        Template temp = cfg.getTemplate("index.ftl");

        /* Merge data-model with template */
        Writer out = new FileWriter(new File("/code/jay/index.html"));
        temp.process(builder, out);
        out.flush();
//
//        for (JavaPackage packag : builder.getPackages()) {
//            System.out.println(packag.getName());
//        }
    }
}
