package magnificus.units;

import java.util.regex.Pattern;

public class Key {
    
    private String string;

    public Key(String string){
        assert string != null && Pattern.compile("([a-z]\\d)?[a-z]+").matcher(string).find() : "Fallo! con " + string;

        this.string = string;
    }

    public void setPreffix(String string, int position){
        this.string = "" + Character.toLowerCase(string.charAt(0)) + position + this.string;
    }

    public void set(String string){
        this.string = string;
    }

    @Override
    public String toString(){
        return this.string;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Key other = (Key) obj;
        if (string == null) {
            if (other.string != null)
                return false;
        } else if (!string.equals(other.string))
            return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((string == null) ? 0 : string.hashCode());
        return result;
    }

}