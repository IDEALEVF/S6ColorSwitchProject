package main.model;

public class Pair<T, Comparable>{
	T arg1;
	Comparable arg2;
	
	public Pair(T arg1, Comparable arg2){
		this.arg1 = arg1;
		this.arg2 = arg2;
	}
	
	public T first(){
		return arg1;
	}
	
	public Comparable second(){
		return arg2;
	}
	
	public void setFirst(T arg1) {
		this.arg1 = arg1;
	}
	
	public void setSecond(Comparable arg2) {
		this.arg2 = arg2;
	}

	@Override
	public String toString() {
		return "Pair [arg1=" + arg1 + ", arg2=" + arg2 + "]";
	}

	/*@Override
	public int compareTo(Object obj) {
		if(obj.getClass() != Pair.class){
			throw new IllegalArgumentException("Impossible de comparer une Pair avec un "+obj.getClass());
		}
		Pair<T, G> paire = (Pair<T, G>) obj;
		if(paire.arg2 < arg2){
			return 1;
		}else if(paire.arg2 > arg2){
			return -1;
		}else {
			return 0;
		}
	}*/

//	@Override
//	public int compareTo(Object obj) {
//		if(obj.getClass() != Pair.class){
//			throw new IllegalArgumentException("Impossible de comparer une Pair avec un "+obj.getClass());
//		}
//		Pair<T, G> paire = (Pair<T, G>) obj;
//		if(paire.arg2 < arg2){
//			return 1;
//		}else if(paire.arg2 > arg2){
//			return -1;
//		}else {
//			return 0;
//		}
//	}
	
}
