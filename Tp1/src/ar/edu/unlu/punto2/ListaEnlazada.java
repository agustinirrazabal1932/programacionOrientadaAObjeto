package ar.edu.unlu.punto2;

public class ListaEnlazada {
    Nodo cabeza=null;

    public ListaEnlazada() {
        cabeza=null;
    }

    public boolean esVacia(){
        return this.cabeza==null;
    }

    public int longitud(){
        int count=0;
        if(this.esVacia()){
            return count;
        }
        Nodo nodoActual=new Nodo();
        nodoActual=cabeza;
        while(nodoActual.getSiguiente()!=null){
            count++;
            nodoActual=nodoActual.getSiguiente();
        }
        return count;
    }

    public void agregarFinal(Object dato){
        Nodo nodoNuevo=cabeza;
        if (this.esVacia()){
            nodoNuevo.setDato(dato);
        }
        Nodo nodoActual=cabeza;
        while(nodoActual.getSiguiente()!=null){
            nodoActual=nodoActual.getSiguiente();
        }
        nodoNuevo.setDato(dato);
        nodoNuevo.setAnterior(nodoActual);
    }

    public void eliminarElemento(Object dato) {
        if (this.esVacia()) {
            System.out.println("La lista está vacía, no hay nada que eliminar.");
            return;
        }

        Nodo nodoActual = cabeza;

        // Caso especial: eliminar el primer nodo
        if (nodoActual.getDato().equals(dato)) {
            cabeza = cabeza.getSiguiente();
            if (cabeza != null) {
                cabeza.setAnterior(null);
            }
            return;
        }

        while (nodoActual.getSiguiente() != null) {
            if (nodoActual.getSiguiente().getDato().equals(dato)) {
                Nodo nodoEliminar = nodoActual.getSiguiente();
                nodoActual.setSiguiente(nodoEliminar.getSiguiente());
                if (nodoEliminar.getSiguiente() != null) {
                    nodoEliminar.getSiguiente().setAnterior(nodoActual);
                }
                nodoEliminar.setAnterior(null);
                nodoEliminar.setSiguiente(null);
                return;
            }
            nodoActual = nodoActual.getSiguiente();
        }

        System.out.println("El elemento no se encuentra en la lista.");
    }

    public Object recuperarElemento(int iterador){
        int ite=1;
        if(this.esVacia()&&iterador>this.longitud()){
            System.out.println("Lista vacia");
            return null;
        }
        Nodo nodoActual;
        nodoActual=cabeza;
        while(nodoActual.getSiguiente()!=null){
            if(ite==iterador){
                return nodoActual.getDato();
            }
            nodoActual=nodoActual.getSiguiente();
            ite++;
        }

        return null;
    }

    public boolean insertarElemento(Object dato, int pos){
        int count=1;
        if(this.esVacia()&&pos>this.longitud()+1){
            System.out.println("Posicion invalida");
            return false;
        }
        Nodo nodoActual=cabeza;
        while(nodoActual.getSiguiente()!=null){
            if(count==pos){
                Nodo nodoNuevo=new Nodo();
                nodoNuevo.setDato(dato);
                nodoNuevo.setSiguiente(nodoActual.getSiguiente());
                nodoNuevo.setAnterior(nodoActual);
                return true;
            }
            count++;
            nodoActual=nodoActual.getSiguiente();
        }
        return false;
    }
}
