import java.time.LocalDate;

public class Mahasiswa {
    private final String name;
    private final LocalDate birthDate;
    private final String NIK;

    public Mahasiswa(String name, LocalDate birthDate, String NIK) {
        this.name = name;
        this.birthDate = birthDate;
        this.NIK = NIK;
    }

    // Getter methods for accessing the attributes
    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getNIK() {
        return NIK;
    }

    @Override
    public String toString() {
        return NIK + "," + name + "," + birthDate;
    }
}
