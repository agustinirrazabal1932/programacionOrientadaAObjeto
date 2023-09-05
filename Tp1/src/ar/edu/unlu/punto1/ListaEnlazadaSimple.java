package ar.edu.unlu.punto1;

public class ListaEnlazadaSimple {

    private Nodo primero= null;

    public void agregar(Object dato){
        Nodo NuevoNodo = new Nodo();
        NuevoNodo.setDato(dato);
        if(primero==null){
            primero=NuevoNodo;
        }
        else {
            Nodo nodoAux= new Nodo();
            nodoAux=primero;
            while (nodoAux.getSiguiente() != null){
                nodoAux=nodoAux.getSiguiente();
            }
            nodoAux.setSiguiente(NuevoNodo);
        }

    }
    public String toString(){
        String acumula="";
        Integer i=1;
        Nodo nodoAux= new Nodo();
        nodoAux=primero;
        if (primero==null){
            acumula="Lista Vacia";
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
    public int longitud(){

        int i=0;
        Nodo nodoAux= new Nodo();
        nodoAux=primero;
        if (primero==null){
        }
        else {
            while (nodoAux != null) {
                nodoAux = nodoAux.getSiguiente();
                i++;
            }
        }
        return i;
    }
    public void eliminar(Object dato){
        int i=0;
        Nodo nodoAux= new Nodo();
        nodoAux=primero;
        while ( (primero!=null) && (primero.getDato()==dato) ){
            primero=primero.getSiguiente();
        }

        while (nodoAux.getSiguiente() != null ) {
            if ( nodoAux.getSiguiente().getDato()==dato) {
                Nodo nodoBorrar = new Nodo();
                nodoBorrar = nodoAux.getSiguiente();
                nodoAux.setSiguiente(nodoBorrar.getSiguiente());
            }else {
                nodoAux=nodoAux.getSiguiente();
            }
        }
    }
    public void insertar(Object dato,int pos){
        if (pos>longitud()+1){
            System.out.println("la posicion es mayor a la cantidad de elementos");
        }
        else {
            Nodo nodoAux= new Nodo();
            nodoAux.setDato(dato);
            if (pos==1){
                nodoAux.setSiguiente(primero);
                primero=nodoAux;
            }
            else {
                Nodo nodoContador= new Nodo();
                nodoContador=primero;
                for (int i=0;i<pos-2;i++){
                    nodoContador=nodoContador.getSiguiente();
                }
                nodoAux.setSiguiente(nodoContador.getSiguiente());
                nodoContador.setSiguiente(nodoAux);
            }
        }
    }

}


