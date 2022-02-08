package at.htl.control;

import at.htl.entity.ContentType;
import at.htl.entity.D_File;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@ApplicationScoped
@Transactional
public class FileRepository implements PanacheRepository<D_File> {

    public final String TARGET_UPLOAD_FOLDER = "Downloads/";

    public String getFileName(MultivaluedMap<String, String> header) {
        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {
                String[] name = filename.split("=");

                return name[1].trim().replaceAll("\"", "");
            }
        }

        return "unknown";
    }

    public File imageHome(){
        var home = System.getProperty("user.home");
        var homeFolder = new File(home);
        return homeFolder;
    }

    //old upload
    public D_File writeFile(byte[] content, String fileName) throws IOException {
        File outputDir = new File(imageHome(),TARGET_UPLOAD_FOLDER);
        File file = new File(TARGET_UPLOAD_FOLDER + fileName);

        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        FileOutputStream fop = new FileOutputStream(file);

        fop.write(content);

        String[] fileTypeArray = fileName.split("\\.");
        String[] parts = fileName.split("/");
        String filename = parts[parts.length - 1];

        if (fileTypeArray[1].equals("mp4") || fileTypeArray[1].equals("mov")) {
            return getEntityManager().merge(
                    new D_File(filename, file.getPath(), "", ContentType.VIDEO)
            );
        } else if (fileTypeArray[1].equals("mp3")) {
            return getEntityManager().merge(
                    new D_File(filename, file.getPath(), "", ContentType.AUDIO)
            );
        }

        fop.flush();
        fop.close();

        return null;
    }

    public D_File createFile(String filename, String path ,String description){
        return getEntityManager().merge(
                new D_File(filename, path, description, ContentType.VIDEO)
        );
    }

}
