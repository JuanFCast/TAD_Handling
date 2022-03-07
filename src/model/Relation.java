package model;

import java.util.*;

public class Relation {
    
    private HashMap<Integer, Integer> hashMap;
    private Set<Integer> domain;
    private Set<Integer> coDomain;

    public Relation(){
    	hashMap = new HashMap<>();
        domain = new HashSet<Integer>();
        coDomain = new HashSet<Integer>();
    }

    public void defineDAndCD(String d, String cd){
        String dParts[] = d.split(",");
        String cdParts[] = cd.split(",");


        for(String i: dParts){
            domain.add(Integer.parseInt(i));
        }

        for(String i: cdParts){
            coDomain.add(Integer.parseInt(i));
        }
    }

    public void defineSet(String s){
        String sParts[] = s.split(", ");

        for(String i: sParts){
            String parts[] = i.split("");
            hashMap.put(Integer.parseInt(parts[1]), Integer.parseInt(parts[3]));
        }
    }
    
    /*
    ( 1 , 2 )
    ( 2 , 1 )
    ( 3 , 3 )
    */

    public boolean isFunction(){
        Function f = new Function(domain, coDomain, hashMap);
        if(f.isFunction()){
            return true;
        } else{
            return false;
        }
    }

    public int fuctionType(){
        Function f = new Function(domain, coDomain, hashMap);
        return f.fuctionType();
    }

    public boolean verifyValuesCDandD(Integer d, Integer cd){
        if(!domain.contains(d)){
            return false;
        } else if(!coDomain.contains(cd)){
            return false;
        } else{
            return true;
        }
    }

}