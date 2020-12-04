/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trai_20_x7_jenni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TRAI_20_X7_jenni implements TRAI_20_X7 {

    /**
     * ITSEARVIOINTI TÃ„HÃ„N:
     * AIKAVAATIVUUS:
     * O(m^2*)
     * 
     * 
     * aikavaativuuden parametrit: m = syÃ¶tejoukkojen mÃ¤Ã¤rÃ¤, n =
     * syÃ¶tejoukkojen yhteinen alkiomÃ¤Ã¤rÃ¤.
     */
    /**
     * Palauttaa tiedon siitÃ¤ mitkÃ¤ joukot leikkaavat keskenÃ¤Ã¤n (siis millÃ¤
     * on yhteisiÃ¤ alkioita). Tulos palautetaan kuvauksena siten, ettÃ¤ jos
     * syÃ¶tteen joukolla Si on yhteisiÃ¤ alkioita jonkun muun syÃ¶tteen joukon
     * Sj kanssa, niin kuvauksen avaimeen Si liittyvÃ¤ssÃ¤ arvossa (joukossa) on
     * viittaus joukkoon Sj (ja pÃ¤invastoin). Kuvaus sisÃ¤ltÃ¤Ã¤ avaimenaan
     * kunkin joukon SS sisÃ¤ltÃ¤mÃ¤n joukon Si ja kunkin avaimen arvona on
     * joukko niistÃ¤ joukoista Sj joilla on vÃ¤hintÃ¤Ã¤n yhteinen alkio joukon
     * Si kanssa.
     *
     * @param SS syÃ¶te (joukkojen joukko)
     * @return kuvaus joukkojen leikkaavuuksista
     */
    /*
    Kirjoita algoritmi joka laskee joukosta joukkoja mitkä joukot leikkaavat toisiaan. Syötteenä
    on joukkojen joukko (Set<Set<E>> SS) (SS ={S1,S2,...,Sm}) ja tuloksena on kuvaus
    (Map<Set<E>, Set<Set<E>>) jossa on avaimena kukin syötejoukko Si
    ja avaimen kuvana on joukko niistä muista syötejoukoista Sj
    joilla on vähintään yksi yhteinen alkio
    joukon Si kanssa. Joukkoja ja alkioita käsitellään viittauksina. Kuvauksen arvoiksi luodaan
    siis uusi joukkojen joukko kutakin alkuperäistä syötejoukkoa kohti ja siihen lisätään ne
    muut syötejoukot (siis viittaukset joukkoihin) joiden kanssa yhteisiä alkioita on. Älä muuta
    syötejoukkoja. Mikä on algoritmisi aikavaativuus jos syötejoukot ovat HashSet-tyyppiä ja
    tuloskuvaus HashMap-tyyppiä ja syötejoukkoja on m kappaletta ja niissä on yhteensä n
    alkiota? Aikavaativuus vaikuttaa arvosteluun.
    Ohjeita: kun teet joukkojen läpikäyntiä ja käsittelyä, mieti aina huolella mitä olet käymässä
    läpi ja mitä tyyppejä käsittelet milloinkin (alkio, alkiojoukko, joukkojenjoukko). Kun suunnitelmasi on 
    valmis ja alat toteuttamaan, muista nämä tyypit myös koodatessasi ja anna
    IDE:n/kääntäjän tarkastaa kaikkien muuttujien ja ilmausten tyypit.
     */
    @Override
    public <E> Map<Set<E>, Set<Set<E>>> leikkaavatJoukot(Set<Set<E>> SS) {
        //palautettava HashMap 
        //O(1)
        Map<Set<E>, Set<Set<E>>> tulos = new HashMap<>();
        
        //Lähdetään looppaamaan parametrina saatua joukkojen joukkoa SS 
        //O(m)
        for (Set<E> avain : SS) {
            //leikkaavat, apuHashSet
            //O(1)
            Set<Set<E>> leikkaavat = new HashSet<>();
            //luodaan iteraattori loopissa käsiteltävän joukon alkioille
            //O(1)
            Iterator<E> iter = avain.iterator();
            //kun iteroitavaa
            //O(n)
            while (iter.hasNext()) {
                //alustetaan muuttuja i iteraattorin seuraavaksi alkioksi
                //O(1)
                E i = iter.next();
                //luodaan sisempi for each loop, jossa käydään läpi samaa parametrina saatua joukkojen joukkoa
                //O(m)
                for (Set<E> joukko : SS) {
                    //mikäli sisemmässä loopissa tarkasteltava alkio(eli joukko) eri kuin uloimmassa
                    //loopissa tarkasteltava alkio(eli joukko) JA sisemmässä loopissa tarkasteltava joukko
                    //sisältää iteraattorin
                    //O(1)
                    if (!joukko.equals(avain) && joukko.contains(i)) {
                        //lisätään apuHashSetiin leikkaavat sisemmän loopin alkio
                        //eli joukko
                        //O(1)
                        leikkaavat.add(joukko);
                    }
                }
            }
            //sijoitetaan palautettavaan HashMapiin:
            //avain: uloimman loopin alkio (eli joukko)
            //kuvaus: sisemmässä loopissa leikkaavat apuHashSetiin lisätyt joukot (joukkojen joukko)
            //O(1)
            tulos.put(avain, leikkaavat);
        }
        //palautetaan tulos
        //O(1)
        return tulos;
    }
}
