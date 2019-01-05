import java.util.Arrays;

public class Pesel {


    int[] table;

    private String gender;

    public Pesel(int[] table) throws ControlNumberException {
        this.table = table;
        if ((this.table[0] * 9 + this.table[1] * 7 + this.table[2] * 3 + this.table[3] * 1 +
                this.table[4] * 9 + this.table[5] * 7 + this.table[6] * 3 + this.table[7] * 1 +
                this.table[8] * 9 + this.table[9] * 7) % 10 != this.table[10])
            throw new ControlNumberException();
        else if (this.table[9] == 0 || this.table[9] == 2 || this.table[9] == 4 ||
                this.table[9] == 6 || this.table[9] == 8)
        {
            gender = "Female";
        } else {
            gender = "Male";
        }
    }



    public static void main(String[] args) {
        try {
            Pesel p = new Pesel(new int[]{7, 7, 1, 0, 1, 5, 0, 1, 3, 1, 4});
            System.out.println("your pesel is correct :" + Arrays.toString(p.getTable()));
            System.out.println("you are :" + p.getGender());
        } catch (ControlNumberException p) {
            System.out.println("PESEL is not correct");
        }
    }

    public int[] getTable() {
        return table;
    }

    public String getGender() {
        return gender;
    }
}

