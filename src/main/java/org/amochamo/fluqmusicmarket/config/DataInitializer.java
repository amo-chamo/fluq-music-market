package org.amochamo.fluqmusicmarket.config;

import org.amochamo.fluqmusicmarket.models.roles.Admin;
import org.amochamo.fluqmusicmarket.repositories.roles.AdminRepository;
import org.amochamo.fluqmusicmarket.repositories.roles.ArtistRepository;
import org.amochamo.fluqmusicmarket.repositories.artiststuff.TrackRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final ArtistRepository artistRepository;

    private final PasswordEncoder passwordEncoder;
    private final ImageReader imageReader;
    private final TrackRepository trackRepository;


    public DataInitializer(AdminRepository adminRepository, PasswordEncoder passwordEncoder, ArtistRepository artistRepository, ImageReader imageReader, TrackRepository trackRepository) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.artistRepository = artistRepository;
        this.imageReader = imageReader;
        this.trackRepository = trackRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // todo
    }

    private static void initializeData() {
        File baseDir = new File("src/main/java/org/amochamo/fluqmusicmarket/config/javadata");

        File[] artistFolders = baseDir.listFiles();

        for (File artistFolder : artistFolders) {
            handleArtistFolder(artistFolder);
        }
    }

    private static void handleArtistFolder(File artistFolder) {
        System.out.println("Inside " + artistFolder.getName() + " folder.");
        File[] artistContents = artistFolder.listFiles();
        ImageReader ir = new ImageReader();

        String name = artistFolder.getName();
        String bio, password;
        byte[] pfp;
        File tracksFolder;

        Map<String, String> info = new HashMap<>();

        for (File artistContent : artistContents) {

            if (artistContent.getName().endsWith(".txt")) {
                info.put(removeExtension(artistContent.getName()), readFileContents(artistContent));
            }

            if (artistContent.getName().endsWith(".jpg")) {
                pfp = ir.read(artistContent.getPath());
            }

            if (artistContent.isDirectory()) {
                tracksFolder = artistContent;
            }

        }

        bio = info.get("bio");
        password = info.get("password");

        


    }



    private static String readFileContents(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.readLine();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
        } catch (IOException e) {
            System.out.println("Some I/O Exception occured.");
        }

        return null;
    }

    private static String removeExtension(String fileName) {
        int index = fileName.lastIndexOf('.');
        return fileName.substring(0, index);
    }

    public static void main(String[] args) {
        initializeData();
    }

    private void initializeAdmin() {

        if (!adminRepository.existsByEmail("admin@fluq.com")) {

            System.out.println("Creating admin...");

            Admin admin = new Admin();
            admin.setEmail("admin@fluq.com");
            admin.setPasswordHash(passwordEncoder.encode("adminbest123"));

            adminRepository.save(admin);
            System.out.println("Admin created successfully.");
        } else {
            System.out.println("Admin already exists.");
        }

    }

    private void initializeArtist(String artistName, String bio, String email,
                                  String rawPassword, byte[] pfp) {

    }


}
