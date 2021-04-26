public class Persona {
    private String nominativo="";
    private double altezza=0;
    private double peso=0;
    private boolean idoneo=false;
    private int id=0;

    //Costruttore di default
public Persona(){

}

//Costruttore master
public Persona(int id, String nominativo, double altezza, double peso, boolean idoneo){
    this.id=id;
    this.nominativo=nominativo;
    this.altezza=altezza;
    this.peso=peso;
    this.idoneo=idoneo;
}

//utilizzato per metodo cercapersona
public Persona(String nominativo){
    this.nominativo=nominativo;

}

//Costruttore di copia
public Persona(Persona persona2) {
    setId(persona2.getId());
    setNominativo(persona2.getNominativo());
    setAltezza(persona2.getAltezza());
    setPeso(persona2.getPeso());
    setIdoneo(persona2.getIdoneo());
}

//SetId
public void setId(int id) {
    this.id = id;
}

//SetNominativo
public void setNominativo(String nominativo) {
    this.nominativo = nominativo;
}

//SetAltezza
public void setAltezza(double altezza) {
    this.altezza = altezza;
}

//SetPeso
public void setPeso(double peso) {
    this.peso = peso;
}
//Setindoneo
public void setIdoneo(boolean idoneo) {
    this.idoneo = idoneo;
}
//GetId
public int getId() {
    return id;
}
//getNominativo
public String getNominativo() {
    return nominativo;
}
//GetAltezza
public double getAltezza() {
    return altezza;
}
//GetPeso
public double getPeso() {
    return peso;
}
//GetIdoneo
public boolean getIdoneo(){
    return idoneo;
}

//Tostring
public String toString() {
    String s="";
    s+="Nominativo: "+getNominativo()+" Altezza: "+getAltezza()+" Peso: "+getPeso()+" Idoneo: "+getIdoneo();
    return s;
}
//Equals con persona
/* public boolean equals(Persona p){
    return(nominativo.equals(p.nominativo) && altezza==p.altezza && peso==p.peso && idoneo==p.idoneo);
} */

//Equals con object
@Override
public boolean equals(Object o){
    Persona p = (Persona) o;
    return(nominativo.equals(p.nominativo) && altezza==p.altezza && peso==p.peso && idoneo==p.idoneo);
}

//iterattiva
public boolean palindroma(String pal){
    boolean cond=false;
    int i=0;
    while(cond==false && i<pal.length()/2){
        if(pal.charAt(i) == pal.charAt(pal.length()-i-1)){

            cond = true;
            }
        i++;
        }
        return cond;
    }

    //ricorsiva
    public boolean palindromaric(String pal){
        boolean cond=false;
        if(pal.length() == 0 || pal.length()==1){
            cond=true;
            return cond;
        }
        else{
            if(pal.charAt(0) == pal.charAt(pal.length()-1)){
                cond=true;
            }
            else{
                cond=false;
            }
        }
        return cond && palindromaric(pal.substring(1,pal.length()-2));
    }
    
}



