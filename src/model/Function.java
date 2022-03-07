package model;

import java.util.*;

public class Function{

    private HashMap<Integer, Integer> relation;
    private Set<Integer> domain;
    private Set<Integer> coDomain;

    public Function(Set<Integer> d,Set<Integer> cd, HashMap<Integer, Integer> hm){
        domain = d;
        coDomain = cd;
        relation = hm;
    }
    
    public boolean isFunction(){
       if(domain.equals(relation.keySet())){
            return true;
       } else{
           return false;
       }
    }

    public int fuctionType(){
        boolean inj = false;
        boolean surj = false;

        if(isInjective()){
            inj = true;
        }

        if(isSurjective()){
            surj = true;
        }

        if(inj == true && surj == true){
            return 3;
        } else if(surj == true){
            return 2;
        } else if (inj == true){
            return 1;
        } else{
            return 0;
        }

    }

    @SuppressWarnings("rawtypes")
	private boolean isInjective(){
        Set<Integer> aux = new HashSet<Integer>();

        for (Map.Entry m : relation.entrySet()) {
            if(!aux.contains(m.getValue())){
                aux.add((Integer) m.getValue());
            } else{
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("rawtypes")
	private boolean isSurjective(){
        Set<Integer> aux = new HashSet<Integer>();

        for (Map.Entry m : relation.entrySet()) {
            aux.add((Integer) m.getValue());
        }

        if(aux.equals(coDomain)){
            return true;
        } else{
            return false;
        }
    }
    
}