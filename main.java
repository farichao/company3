class Perusahaan {
    private final String namaPerusahaan;

    public Perusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }
}

class Util {
    public static String formatRupiah(long amount) {
        return "Rp" + String.format("%,d", amount).replace(",", ".");
    }
}

class Karyawan {
    private String nama;
    private long gajiPokok;
    private Perusahaan perusahaan;

    public Karyawan(String nama, long gajiPokok, Perusahaan perusahaan) {
        this.gajiPokok = gajiPokok;
        this.perusahaan = perusahaan;
        setNama(nama);
    }

    public long hitungGaji() {
        return gajiPokok;
    }

    public void setNama(String nama) {
        if (nama.length() >= 4) {
            this.nama = nama;
        } else {
            throw new IllegalArgumentException("Nama harus minimal 4 karakter!");
        }
    }

    public String getNama() {
        return nama;
    }

    public String getGajiPokok() {
        return Util.formatRupiah(gajiPokok);
    }

    public void info() {
        System.out.println("Nama Karyawan  : " + getNama());
        System.out.println("Gaji Pokok     : " + getGajiPokok());
        System.out.println("Perusahaan     : " + perusahaan.getNamaPerusahaan());
        System.out.println("-------------------------");
    }

    public void infoGaji() {
        System.out.println("Nama Karyawan : " + nama);
        System.out.println("Total Gaji    : " + Util.formatRupiah(hitungGaji()));
        System.out.println("------------------------");
    }
}

class Programmer extends Karyawan {
    private long bonus;

    public Programmer(String nama, long gajiPokok, long bonus, Perusahaan perusahaan) {
        super(nama, gajiPokok, perusahaan);
        this.bonus = bonus;
    }

    @Override
    public long hitungGaji() {
        return super.hitungGaji() + bonus;
    }
}

class Manager extends Karyawan {
    private long insentif;
    private String divisi;

    public Manager(String nama, long gajiPokok, Perusahaan perusahaan, long insentif, String divisi) {
        super(nama, gajiPokok, perusahaan);
        this.insentif = insentif;
        this.divisi = divisi;
    }

    @Override
    public long hitungGaji() {
        return super.hitungGaji() + insentif;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Divisi         : " + divisi);
    }
}

public class Tahap3 {
    public static void main(String[] args) {
        Perusahaan p1 = new Perusahaan("PT. Kurma");
        Karyawan k1 = new Karyawan("Bintan", 2000000L, p1);
        Karyawan k2 = new Karyawan("Andin", 4000000L, p1);
        Programmer c1 = new Programmer("Mohan", 1000000L, 300000L, p1);
        Manager m1 = new Manager("Paul", 1000000L, p1, 999900L, "Perkap");

        k1.info();
        k2.info();
        k1.infoGaji();
        c1.infoGaji();
        m1.infoGaji();
    }
}
