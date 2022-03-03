feb 2017 Polygon 

public class Polygon {
	private static class Vertex {
		double x, y;
	}
	private List<Vertex> vertices;
	
	public boolean equals(Object obj){
		if(obj==null)
			return false;
		if(obj.getClass()!=this.getClass())
			return false;
		Polygon p = (Polygon)obj;
		//due poligoni sono uguali se hanno gli stessi vertici, no?
		return non lo so.
	}
}



//vuole sapere se le specifiche vanno bene oppure no. 
a)	Hanno lo stesso numero di vertici			OK
	//mi immagino che la lista dei vertici deve essere uguale sia per p che per p2 (sono oggetti di tipo Polygon)
	rif: p.equals(p) = true	//sì perchè è lo stesso oggetto con gli stessi vertici.
	sim: p.equals(p2) = true => p2.equals(p) = true  //secondo la specifica, devo cercare p e p2 tali che rispettino la prima condizione 
													//(cioè liste di vertici di ugual lunghezza) e che valga anche il contrario nell'equals
	trans: p.equals(p2) = true ^ p2.equals(p3) = true => p.equals(p3) = true // per me è ok perchè devo scegliere p p2 e p3 tali che le 
																			//prime due condizioni siano vere. quando p è uguale a p2? 
																			//quando hanno lo stesso numero di vertici (cioè la lunghezza 
																			//delle liste è la stessa.) fisso la lunghezza a 3. quindi 3 è
																			// uguale a 3. e anche 3 è uguale a 3 (p2 e p3) quindi vale
																			// anche la 3 proprietà


b) Sono entrambi triangoli						KO
	rif: p.equals(p) = true //chiaramente non vale mai questa proprietà perchè se prendo un p che non è triangolo (ad esempio quadrato)		
							//allora non sarà mai uguale a se stesso perchè per soddisfare la proprietà bisogna che sia un triangolo


c) Hanno gli stessi vertici, anche se in ordine diverso			OK
   //ok considera la lista dei vertici. come ben sappiamo se una lista è: [1,2,3] sarà diversa da [3,2,1] anche se gli elementi sono uguali
   //questo perchè, a differenza dei set, nelle liste non vale la regola di avere gli stessi elementi. 
	rif: p.equals(p) = true 	//trovato una lista di vertici di p (oggetto poligono) questa proprietà è vera
	sim: p.equals(p2) = true => p2.equals(p) = true 
		 //per far valere il primo equals, devo fissare p e p2. li fisso come se fossero entrambi 1 2 3 (altrimenti non sarebbe vera la
		 //1 condizione). quindi se la lista di p è 1 2 3 e idem la lista di p2, allora vale anche il secondo equals.
		 //in più, vale anche se metto al contrario 3 2 1. sono la stessa ed identica lista. 
	//anche la transitività credo che funzioni. l'unica cosa che NON mi convince è che il contrario della lista non è uguale alla lista 
	//stessa... non so come spiegare. 

d) Hanno almeno un vertice in comune		KO
//questo perchè per la riflessività non c'è problema. se fisso una lista è uguale a se stessa
//per la simmetria, se fisso p e p2 con un vertice in comune, varrà anche il contrario
//per la transitività, invece non va bene. fissa le liste di p p2 e p3 come [1,2,3], [3,4,5], [5,6,7]
						//vedrai che , p e p2 hanno un vertice comune (3). p2 e p3 hanno un vertice comune (5) ma p e p3 NON hanno vertici comuni
//COME FACCI UN'IMPLEMENTAZIONE DI UNA SPECIFICA NON VALIDA?


e) Si trovano nello stesso quadrante (con tutti i loro vertici)
	rif: //NO!! immagina che la lista dei vertici dell'oggetto p (ogni oggetto di classe polygon ha una lista) sia [1,2,-3].
			//secondo questa specifica, allora, p NON è uguale a se stesso perchè i vertici non appartengono allo stesso quadrante.





