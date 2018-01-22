package main.model;

public class Pair<T, G>{
	T arg1;
	G arg2;
	
	Pair(T arg1, G arg2){
		this.arg1 = arg1;
		this.arg2 = arg2;
	}
	
	T first(){
		return arg1;
	}
	
	G second(){
		return arg2;
	}

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
