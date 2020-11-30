package Tp2Poo.tp5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import Tp2Poo.tp5.model.Features;
import Tp2Poo.tp5.model.Geometry;
import Tp2Poo.tp5.model.Main;
import Tp2Poo.tp5.model.Trucs;
import Tp2Poo.tp5.model.openWeather;

@Controller
public class meteoControlleur {
	
	@PostMapping("/meteo")
	public String meteoPost(@RequestParam(name="cAdr") String adresse, Model model) {
		model.addAttribute("adr", adresse);//On passe l'adresse à la page suivante
		
		// On récupère la latitude et la longitude à partir de l'adresse donnée par l'utilisateur.
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "https://api-adresse.data.gouv.fr/search/?q=";
		Features response = restTemplate.getForObject(fooResourceUrl + adresse, Features.class);
        Trucs trucs = response.getFeatures().get(0);
        Geometry geometry = trucs.getGeometry();
        Double lon = geometry.getCoordinates().get(0);
        Double lat = geometry.getCoordinates().get(1);

        // On récupère la température et la température ressentie à partir de la latitude et la longitude obtenues avant.
        RestTemplate rest = new RestTemplate();
		String url = "http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&units=metric&appid=434a28dd340e75797d7733e857068ad6";
		openWeather reponse2 = rest.getForObject(url, openWeather.class);
        Main main = reponse2.getMain();
        float temperature = main.getTemp();
        float ressenti = main.getFeels_like();

        //On passe les 2 températures à la page météo
        model.addAttribute("temp", temperature);
        model.addAttribute("ress", ressenti);
        
		return "meteo";
	}
}
