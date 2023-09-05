package ar.edu.unlu.punto4;

public class Cola {
    private Nodo principio= null;
    private Nodo finDeCola=null;

    public void agregar(Object dato){
        Nodo nuevoNodo= new Nodo();
        nuevoNodo.setDato(dato);
        if (principio==null){
            principio=nuevoNodo;
            nuevoNodo.setSiguiente(finDeCola);
            finDeCola=nuevoNodo;
        }
        else {
            finDeCola.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(null);
            finDeCola=nuevoNodo;
        }

    }
    public String toString(){
        String acumula="";
        Integer i=1;
        Nodo nodoAux= new Nodo();
        nodoAux=principio;
        if (principio==null){
            acumula="Cola Vacia";
        }
        else {
            while (nodoAux != null) {
                acumula += "Nodo " + i + ":" + nodoAux.getDato()+"\n";
                nodoAux = nodoAux.getSiguiente();
                i++;
            }
        }
        return acumula;
    }

    public Object desencolar(){
        Nodo nodoBorrar= new Nodo();
        nodoBorrar=principio;
        if ( (principio==null) ){
            return null;
        }
        else {
            principio=principio.getSiguiente();
            return nodoBorrar.getDato();
        }
    }

    public Object verFinal(){
       return finDeCola.getDato();
    }
    public Object verPrincipio(){
        return principio.getDato();
    }
}

