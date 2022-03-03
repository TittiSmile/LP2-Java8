Engine Comparator, 2016-4-21
//CRITERIO DI ORDINAMENTO TRA OGGETTI. devi controllare che sia una relazione d'ordine totale.

a) -1 se a ha cilindrata minore di b; 1 se a ha cilindrata maggiore di b
	a.1) sgn(a.compareTo(b)) == -sgn(b.compareTo(a))			//RIFLESSIVA ANTISIMMETRICA
		a=10	b=20   //chiaramente, a e b li scelgo in funzione di quello che devo fare... 
					   //ho preso in considerazione la prima parte della specifica
		-1 == 1 //perchè? 
		//la funzione segno funziona così: a ha cilindrata minore di b? sì (abbiamo fissato i nostri a e b) 
		//ora, scambiando b ed a, b ha cilindrata maggiore di a? sì
	a.2) a.compareTo(b) < 0 ^ b.compareTo(c) < 0 => a.compareTo(c) < 0     //TRANSITIVA
		 a=10 	b=20 	c=30
		 10 cilindrata minore di 20? sì
		 20 cilindrata minore di 30? sì
		 10 cilindrata minore di 30.
	a.3) a.compareTo(b) == 0 => sgn(a.compareTo(c)) == sgn(b.compareTo(c))
		 //quando a.compareto(b)==0? dalla specifica non viene detto ma ciò accade quando a=b (cioè stessa cilindrata)
		 a=10  	b=10 	c=20
		 a e b stessa cilindrata -> 0 
		 a cilindrata minore di c = -1
		 b cilindrata minore di c = -1


b) -1 se a ha potenza minore della metà di b; 1 se a ha potenza maggiore del doppio di b  //potenza non aritmetica 
	b.1) a= 2 b = 10
		-1 = 1 
	b.2) a=1 b=4 c=10
	 	 -1 -1 -1
	b.3) //a potenza uguale alla metà di b
			a=2 b=4 c=8 			//proprietà non valida (se vale la prima tra a e b deve valere anche l'altra)







