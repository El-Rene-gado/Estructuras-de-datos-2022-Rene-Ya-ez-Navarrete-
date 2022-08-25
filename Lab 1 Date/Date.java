package lab.pkg1.date;

/**
 *
 * @author Rene Yañez
 * 
 */
public class Date {
    
    private int date;
    
    // constructor date
    public Date(int date) {
        if(date!=0){this.date = date;}
        this.date = 0;
    }

        // 1111 1111 1111 0000 0000 0000 0000 0000
        // 0000 0000 0000 0000 0000 1111 1111 1111  (date>>20)
        // Esta clase retorna el año
    public int getAnio() {
        int a=date>>>20;
        return a;
    }

        // 0000 0000 0000 1111 0000 0000 0000 0000
        // 1111 0000 0000 0000 0000 0000 0000 0000  (date>>12)
        // 0000 0000 0000 0000 0000 0000 0000 1111  (date<<<28)
        // Esta clase retorna el mes
    public int getMes() {
        int a=date<<12;
        a=a>>>28;
        return a;
    }
    
        // 0000 0000 0000 0000 1111 1000 0000 0000
        // 1111 1000 0000 0000 0000 0000 0000 0000  (date>>16)
        // 0000 0000 0000 0000 0000 0000 0001 1111  (date<<<28)
        // Esta clase retorna el dia
    public int getDia() {
        int a=date<<16;
        a=a>>>27;
        return a;
    }
        
        // 0000 0000 0000 0000 0000 1111 1111 1111
        // Esta clase ingresa el año
    public void setAnio(int anio) {
        if(anio<=4095&&anio>0){
            int mskBorra=~(4095<<20);
            this.date=date& mskBorra;
            int msk=anio;
            msk=msk<<20;
            this.date=this.date|msk;
        }
    }
                                
        // 0000 0000 0000 0000 0000 0000 0000 / 0000
        // Esta clase ingresa el mes
    public void setMes(int mes) {
        if(mes<=12&&mes>0){int msk=mes;
            int mskBorra=~(15<<16);
            this.date=date& mskBorra;
            msk=msk<<16;
            this.date=this.date|msk;
        }
    }
    
        // 0000 0000 0000 0000 0000 0000 000/0 0000
        // Esta clase ingresa el dia
    public void setDia(int dia) {
        if(dia<=31&&dia>0){int msk=dia;
            int mskBorra=~(31<<11);
            this.date=date& mskBorra;
            msk=msk<<11;
            this.date=this.date|msk;
        }
    }

    @Override
    public String toString() {
        return "Date: " + getDia()+"/"+getMes()+"/"+getAnio();
    }
    
    
}
