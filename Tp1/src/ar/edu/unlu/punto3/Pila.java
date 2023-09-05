package ar.edu.unlu.punto3;

public class Pila {
    Nodo base;

    public Pila(){
        base=null;
    }


    public boolean esVacia(){
        return base==null;
    }


    //Regresa el último elemento insertado en la pila
    public Object ultimoElemento(){
        Nodo nodoActual;
        nodoActual=base;
        if(this.esVacia()){
            System.out.println("Pila vacia");
            return false;
        }
        while(nodoActual.getSiguiente()!=null){
            nodoActual=nodoActual.getSiguiente();
        }
        return nodoActual.getDato();
    }

    //inserta un elemento en el tope de la pila.
    public void insertar(Object dato){
        Nodo nodoActual;
        nodoActual=base;
        if (this.esVacia()){
            nodoActual.setDato(dato);
        }
        while(nodoActual.getSiguiente()!=null){
            nodoActual=nodoActual.getSiguiente();
        }
        Nodo nodoNuevo=new Nodo();
        nodoNuevo.setDato(dato);
        nodoActual.setSiguiente(nodoActual);
    }
    //Regresa verdadero si la pila está llena.
    public int size(){
        int count=0;
        if(this.esVacia()){
            return count;
        }
        Nodo nodoActual;
        nodoActual=base;
        while(nodoActual.getSiguiente()!=null){
            count++;
            nodoActual=nodoActual.getSiguiente();
        }
        return count;
    }
}

