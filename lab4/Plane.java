

class Plane {
    private String Model;
   private String Color;
    private String Country;
   public int length;
    public int crew;

    Plane(String Model, String Color, String Country, int length , int crew){
        this.Model = Model;
        this.Color = Color;
        this.Country = Country;
        this.length = length;
        this.crew = crew;

    }


    String getColor() {
        return Color;
    }

    String getModel() {
        return Model;
    }

    String getCountry() {
        return Country;
    }

    int getcrew() {
        return crew;
    }

    int getlength() {
        return length;
    }

    public void print() {
        System.out.printf("%-5s %-6s Country: %-3s length: %-3d crew: %-3d",
                this.getModel(),
                this.getColor(),
                this.getCountry(),
                this.getlength(),
                this.getcrew());
        System.out.println();
    }
}