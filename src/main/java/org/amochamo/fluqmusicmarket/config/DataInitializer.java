package org.amochamo.fluqmusicmarket.config;

import org.amochamo.fluqmusicmarket.models.roles.Admin;
import org.amochamo.fluqmusicmarket.models.roles.Artist;
import org.amochamo.fluqmusicmarket.repositories.AdminRepository;
import org.amochamo.fluqmusicmarket.repositories.ArtistRepository;
import org.amochamo.fluqmusicmarket.repositories.TrackRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

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
//        initializeAdmin();
//        initializeArtist(
//                "Nicolas Jaar",
//                Optional.empty(),
//                "nicolas@jaar.com",
//                "NicJ44r!",
//                Optional.empty()
//        );
//        initializeArtist(
//                "Tame Impala",
//                Optional.of("This is bio of Tame Impala."),
//                "tame@impala.com",
//                "T4m3Imp41a",
//                Optional.empty()
//        );
//        initializeArtist(
//                "DOS",
//                Optional.of("Not Windows, DOS"),
//                "dos@gmail.com",
//                "W1nd0s",
//                Optional.of("src/main/java/org/amochamo/fluqmusicmarket/config/data/ms-dos-ibm-pc.jpg")
//        );
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

    private void initializeArtist(String artistName, Optional<String> bio, String email, String rawPassword,
                                  Optional<String> pfpPath) {

        if (!artistRepository.existsByArtistName(artistName)) {
            System.out.println("Creating artist - " + artistName + ".");

            Artist artist = new Artist();
            artist.setArtistName(artistName);
            artist.setBio(bio.orElse("No bio present."));
            artist.setEmail(email);
            artist.setPasswordHash(passwordEncoder.encode(rawPassword));
            artist.setProfilePicture(imageReader.read(pfpPath.orElse("src/main/resources/static/default_artist.jpg")));

            artistRepository.save(artist);
            System.out.println("Artist " + artistName + " was created successfully.");
        } else {
            System.out.println("Artist " + artistName + " already exists.");
        }

    }

    private void initializeTrack(String artistName, String title, BigDecimal price, Integer release_year,
                                 String musicFilePath, String previewFilePath, String coverImagePath) {
        System.out.println("Creating track ");

    }

}
