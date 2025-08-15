public class details {
    String name;
    String describe;
    String status;
    String contact;

    public details(String name,String describe, String status, String contact){
        this.name=name;
        this.describe=describe;
        this.status=status;
        this.contact=contact;
    }
    @Override
    public String toString(){
        return name+"|"+describe+"|"+status+"|"+contact;
    }

    public static details fromString(String line){
        String[] part=line.split("\\|");
        return new details(part[0],part[1],part[2],part[3]);
    }
}
