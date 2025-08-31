public class details {
    String name;
    String describe;
    String status;
    String location;
    String contact;
    String date;
    public details(String name,String describe, String status,String location, String contact,String date){
        this.name=name;
        this.describe=describe;
        this.status=status;
        this.location=location;
        this.contact=contact;
        this.date=date;
    }
    @Override
    public String toString(){
        return name+"|"+describe+"|"+status+"|"+location+"|"+contact+"|"+date;
    }

    public static details fromString(String line){
        String[] part=line.split("\\|");
        return new details(part[0],part[1],part[2],part[3],part[4],part[5]);
    }
}
