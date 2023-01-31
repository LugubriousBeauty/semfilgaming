package com.mindhub.semfilgaming;

import com.mindhub.semfilgaming.Models.*;
import com.mindhub.semfilgaming.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SemfilgamingApplication {
	private final ClientRepository clientRepository;



	public SemfilgamingApplication(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SemfilgamingApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner initData(ProductRepository productRepository, CategoryRepository categoryRepository,
									  ProductCategoryRepository productCategoryRepository, ProductGenreRepository productGenreRepository,
									  GenreRepository genreRepository) {
		return (args) -> {

			List<String> screenShootList = List.of (
					"https://cdn.akamai.steamstatic.com/steam/apps/892970/ss_a600a7d4ca954543e22f571a9629521a13f82143.600x338.jpg?t=1673342039",
					"https://cdn.akamai.steamstatic.com/steam/apps/892970/ss_3db385fc1223914dadb199ac8682683a8c59454e.600x338.jpg?t=1673342039");

			List<String> trailersList = List.of(
					"http://cdn.akamai.steamstatic.com/steam/apps/256919598/movie480.mp4?t=1670328406",
					"http://cdn.akamai.steamstatic.com/steam/apps/256820008/movie480.mp4?t=1612278985"
					);

			Product valheim = new Product("<h1>Acerca del juego</h1>Un guerrero muerto en batalla," +
					" las Valquirias llevaron su alma a Valheim, el décimo mundo nórdico. " +
					"Rodeado de criaturas del caos y antiguos enemigos de los dioses, " +
					"eres el guardián más joven del purgatorio primordial, encargado de matar " +
					"a los viejos rivales de Odín y poner orden en Valheim. <br><br>Tus pruebas comienzan en el " +
					"pacífico centro desarmado de Valheim, pero los dioses recompensan a los valientes y la gloria " +
					"te aguarda. Aventúrate a través de bosques imponentes y montañas cubiertas de nieve, explora y " +
					"recolecta materiales valiosos para crear armas más letales, armaduras más resistentes, fortalezas " +
					"vikingas y puestos de avanzadilla. Construye un poderoso barco y navega por los grandes océanos " +
					"en busca de tierras exóticas... pero ten cuidado de navegar demasiado lejos...  <br><br><ul " +
					"class=\\\"bb_ul\\\"><li>Enorme mundo generado proceduralmente: explora y habita tierras místicas, " +
					"desde bosques misteriosos hasta imponentes cadenas montañosas cubiertas de nieve y prados " +
					"impresionantes, llenos de criaturas legendarias para luchar y vida silvestre para cazar." +
					"<br></li><li>Multijugador cooperativo - por si deseas enfrentarte a estas tierras sólo o " +
					"aventurarte con aliados de confianza, Valheim soporta servidores independientes, alojados " +
					"por jugadores y creación de mundos infinitos.<br></li><li>Sistema de combate punitivo basado " +
					"en esquivar y bloquear en el que dispondrás de una amplia gama de armas<br></li><li>Construye " +
					"y navega en barcos, desde frágiles navíos hasta majestuosos barcos de guerra, construye barcos " +
					"legendarios para conquistar los mares y descubrir nuevas tierras.<br></li><li>Invoca y " +
					"derrota a los vengativos jefes legendarios de los mitos y leyendas, y recoge trofeos para " +
					"progresar y crear nuevos y poderosos objetos.<br></li><li>Sistema flexible para construir " +
					"casas y bases - crea salas de hidromiel, granjas, asentamientos, puestos de avanzada, castillos " +
					"y más.<br></li><li>Creación intuitiva de objetos - forja las mejores armas y armaduras, y " +
					"elabora comida y aguamiel artesanalmente.<br></li><li>Servidores dedicados - para jugadores " +
					"que desean ejecutar un servidor persistente.</li></ul>",
					"Un brutal juego de supervivencia y exploración multijugador, ambientado en un purgatorio generado " +
							"de forma procedural e inspirado en la cultura vikinga. ¡Lucha, construye y conquista " +
							"tu viaje en una saga digna de la bendición de Odin!",
					"<strong>Mínimo:</strong><br><ul class=\"bb_ul\"><li>Requiere un procesador y un sistema " +
							"operativo de 64 bits<br></li><li><strong>SO:</strong> Windows 7 or later<br>" +
							"</li><li><strong>Procesador:</strong> 2.6 GHz Quad Core or similar<br></li>" +
							"<li><strong>Memoria:</strong> 8 GB de RAM<br></li><li><strong>Gráficos:" +
							"</strong> GeForce GTX 950 or Radeon HD 7970<br></li><li><strong>DirectX:" +
							"</strong> Versión 11<br></li><li><strong>Almacenamiento:</strong> 1 GB de " +
							"espacio disponible<br></li><li><strong>Notas adicionales:</strong> " +
							"</ul>",
					"<strong>Recomendado:</strong><br><ul class=\"bb_ul\"><li>Requiere un procesador y " +
							"un sistema operativo de 64 bits<br></li><li><strong>SO:</strong> Windows 7 or " +
							"later<br></li><li><strong>Procesador:</strong> i5 3GHz or Ryzen 5 3GHz<br></li>" +
							"<li><strong>Memoria:</strong> 16 GB de RAM<br></li><li><strong>Gráficos:</strong> GeForce " +
							"GTX 1060 or Radeon RX 580<br></li><li><strong>DirectX:</strong> Versión 11<br></li><li>" +
							"<strong>Red:</strong> Conexión de banda ancha a Internet<br></li><li><strong>Almacenamiento:" +
							"</strong> 1 GB de espacio disponible</li></ul>",
					"Valheim",
					"https://cdn.akamai.steamstatic.com/steam/apps/892970/header.jpg?t=1673342039",
					"http://www.valheimgame.com",
					"https://cdn.akamai.steamstatic.com/steam/apps/892970/page_bg_generated_v6b.jpg?t=1673342039",
					"https://cdn.akamai.steamstatic.com/steam/apps/892970/page.bg.jpg?t=1673342039",
					799D,
					1D,
					25,
					54,
					screenShootList,
					trailersList
					);
			Client lucia = new Client("lucividal09@gmail.com", passwordEncoder.encode("caca"), "Lucia", "Vidal" , LocalDate.now());
			lucia.setEnabled(true);
			clientRepository.save(lucia);

			Genre action = new Genre("Action");
			Genre indie = new Genre("Indie");
			Genre adventure = new Genre("Adventure");
			Genre massivelyMultiplayer = new Genre("Massively Multiplayer");
			Genre rpg = new Genre("RPG");
			Genre simulation = new Genre("simulation");
			Genre strategy = new Genre("strategy");
			Genre casual = new Genre("casual");
			Genre sports = new Genre("sports");
			Genre racing = new Genre("racing");


			Category rol = new Category("Rol");
			Category shooter = new Category("shooter");
			genreRepository.save(action);
			genreRepository.save(indie);
			genreRepository.save(adventure);
			genreRepository.save(massivelyMultiplayer);
			genreRepository.save(rpg);
			genreRepository.save(simulation);
			genreRepository.save(strategy);
			genreRepository.save(casual);
			genreRepository.save(sports);
			genreRepository.save(racing);
			categoryRepository.save(shooter);
			categoryRepository.save(rol);
			ProductCategory first = new ProductCategory();
			ProductCategory second = new ProductCategory();
			ProductGenre firstGenre = new ProductGenre();
			ProductGenre secondGenre = new ProductGenre();

			rol.addCategories(first);
			shooter.addCategories(second);

			simulation.addGenre(secondGenre);
			action.addGenre(firstGenre);



			productRepository.save(valheim);
			valheim.addGenre(firstGenre);
			valheim.addCategories(first);
			valheim.addGenre(secondGenre);
			valheim.addCategories(second);
			productCategoryRepository.save(first);
			productGenreRepository.save(firstGenre);
			productCategoryRepository.save(second);

			productGenreRepository.save(secondGenre);
			productRepository.save(valheim);







//			valheim.addCategory(rol);
//			categoryRepository.save(rol);
//			productRepository.save(valheim);



			/*Product skyrim = new Product("Winner of more than 200 Game of the Year Awards, " +
					"Skyrim Special Edition brings the epic fantasy to life in stunning detail. " +
					"The Special Edition includes the critically acclaimed game and add-ons with " +
					"all-new features like remastered art and effects, volumetric god rays, dynamic " +
					"depth of field, screen-space reflections, and more. Skyrim Special Edition also" +
					" brings the full power of mods to the PC and consoles.  New quests, environments," +
					" characters, dialogue, armor, weapons and more – with Mods, there are no limits to what" +
					" you can experience.",
					"Winner of more than 200 Game of the Year Awards, Skyrim Special Edition brings" +
							" the epic fantasy to life in stunning detail. The Special Edition " +
							"includes the critically acclaimed game and add-ons with all-new features " +
							"like remastered art and effects, volumetric god rays, dynamic depth of field, " +
							"screen-space reflections, and more.",
					"<strong>Minimum:</strong><br><ul class=\"bb_ul\"><li><strong>OS:</strong>" +
							" Windows 7/8.1/10 (64-bit Version)<br></li><li><strong>Processor:" +
							"</strong> Intel i5-750/AMD Phenom II X4-945<br></li><li><strong>Memory:" +
							"</strong> 8 GB RAM<br></li><li><strong>Graphics:</strong> NVIDIA GTX 470 " +
							"1GB /AMD HD 7870 2GB<br></li><li><strong>Storage:</strong> 12 GB available " +
							"space</li></ul>",
					"<strong>Recommended:</strong><br><ul class=\"bb_ul\"><li><strong>OS:</strong> " +
							"Windows 7/8.1/10 (64-bit Version)<br></li><li><strong>Processor:" +
							"</strong> Intel i5-2400/AMD FX-8320<br></li><li><strong>Memory:</strong> " +
							"8 GB RAM<br></li><li><strong>Graphics:</strong> NVIDIA GTX 780 3GB /AMD " +
							"R9 290 4GB<br></li><li><strong>Storage:</strong> 12 GB available " +
							"space</li></ul>",
					"The Elder Scrolls V: Skyrim Special Edition",
					"https://cdn.akamai.steamstatic.com/steam/apps/489830/header.jpg?t=1650909796",
					"",
					"https://cdn.akamai.steamstatic.com/steam/apps/489830/page_bg_generated_v6b.jpg?t=1650909796",
					"https://cdn.akamai.steamstatic.com/steam/apps/489830/page.bg.jpg?t=1650909796",
					7400D,
					1D,
					10);
			productRepository.save(skyrim);

			Product sims = new Product(
					"Da rienda suelta a tu imaginación y crea un mundo único de Sims a " +
							"tu imagen y semejanza. Descárgalo gratis y personaliza todos los " +
							"detalles, desde tus Sims a sus hogares y mucho más. Elige el aspecto, " +
							"la personalidad y la ropa de tus Sims y decide cómo van a vivir día a día. " +
							"Diseña y construye casas increíbles para cada familia y luego decóralas con " +
							"tus muebles y elementos decorativos favoritos. Desplázate a distintos barrios" +
							" donde podrás conocer diferentes Sims y enterarte de sus vidas. Descubre " +
							"bellos lugares con entornos característicos y embárcate en aventuras " +
							"espontáneas. Gestiona los altibajos de la vida cotidiana de tus Sims y " +
							"observa qué pasa cuando recreas situaciones de tu vida real. Cuenta tus " +
							"historias como quieras desarrollando relaciones, asignando profesiones y " +
							"aspiraciones y sumergiéndote en este extraordinario juego en el que las " +
							"posibilidades son infinitas.<br><br><strong>Descárgalo gratis.</strong> " +
							"El juego básico de Los Sims™ 4 se puede descargar gratis. Obtén multitud de" +
							" opciones para construir casas, personalizar a tus Sims y definir sus " +
							"personalidades. Crea sus historias mientras exploras mundos vibrantes y " +
							"descubres nuevas formas de ser tú.",
					"Disfruta del poder de crear y controlar a personas en un mundo virtual" +
							" donde no hay reglas. ¡Ejerce tu poder con total libertad, diviértete y " +
							"juega a la vida!",
					"<strong>Mínimo:</strong><br><ul class=\"bb_ul\"><li>Requiere un " +
							"procesador y un sistema operativo de 64 bits<br></li><li><strong>SO:</strong> " +
							"(64 bits) Windows 10<br></li><li><strong>Procesador:</strong> Intel Core i3-3220 " +
							"a 3,3 GHz (2 núcleos, 4 hilos), AMD Ryzen 3 1200 a 3,1 GHz (4 núcleos) o superior" +
							"<br></li><li><strong>Memoria:</strong> 4 GB de RAM<br></li><li><strong>Gráficos:" +
							"</strong> 128 MB de memoria gráfica y compatibilidad con Pixel Shader 3.0 Tarjetas " +
							"de vídeo compatibles: Tarjetas gráficas compatibles: NVIDIA GeForce 6600 o superior, " +
							"ATI Radeon X1300 o superior, Intel GMA X4500 o superior<br></li><li><strong>DirectX:" +
							"</strong> Versión 11<br></li><li><strong>Red:</strong> Conexión de banda ancha a " +
							"Internet<br></li><li><strong>Almacenamiento:</strong> 26 GB de espacio " +
							"disponible</li></ul>",
					"<strong>Recomendado:</strong><br><ul class=\"bb_ul\"><li>Requiere un " +
							"procesador y un sistema operativo de 64 bits<br></li><li><strong>SO:</strong> " +
							"Windows 10 de 64 bits<br></li><li><strong>Procesador:</strong> Intel Core i5 (4 " +
							"núcleos) o AMD Ryzen 5 o superior<br></li><li><strong>Memoria:</strong> 8 GB de RAM" +
							"<br></li><li><strong>Gráficos:</strong> 1 GB de RAM de vídeo, NVIDIA GTX 650, AMD " +
							"Radeon HD 7750 o superior<br></li><li><strong>DirectX:</strong> Versión 11<br></li>" +
							"<li><strong>Red:</strong> Conexión de banda ancha a Internet<br></li><li><strong>" +
							"Almacenamiento:</strong> 51 GB de espacio disponible</li></ul>",
					"The Sims™ 4",
					"https://cdn.akamai.steamstatic.com/steam/apps/1222670/header.jpg?t=1674232903",
					"https://www.ea.com/games/the-sims/the-sims-4",
					"https://cdn.akamai.steamstatic.com/steam/apps/1222670/page_bg_generated_v6b.jpg?t=1674232903",
					"https://cdn.akamai.steamstatic.com/steam/apps/1222670/page.bg.jpg?t=1674232903",
					350D,
					1D,
					5);

			productRepository.save(sims);


			Product grandTheftAuto = new Product(
					"El Criminal Enterprise Starter Pack es la forma más rápida que tienen" +
							" los nuevos jugadores de Grand Theft Auto Online de dar un impulso a" +
							" sus imperios criminales. No lo compres si ya tienes dicho pack.<br />" +
							"\r\n<br />\r\nAccede a varios de los contenidos más emocionantes y " +
							"famosos de GTA Online, como propiedades, negocios, armas, vehículos y más, " +
							"que suman un total de más de 10 000 000 de GTA$.<br />\r\n<br />\r\nInicia " +
							"proyectos empresariales desde tu oficina de ejecutivo del Maze Bank Oeste, " +
							"investiga potentes armas desde el búnker subterráneo de Paleto o atraviesa las " +
							"calles en una amplia variedad de vehículos, como un supercoche, motos, el Dune FAV " +
							"armado y más.<br />\r\n<br />\r\nAdemás, conseguirás 1 000 000 de GTA$ y armas " +
							"potentes que te ayudarán a iniciar tu reinado en Los Santos y el condado de Blaine." +
							"<br />\r\n<br />\r\nEl Criminal Enterprise Starter Pack te da artículos por un valor " +
							"de más de 10 000 000 de GTA$ con acceso a Grand Theft Auto Online para conseguir:<br " +
							"/>\r\n<br />\r\nBonificación de dinero de 1 000 000 de GTA$<br />\r\n<br />\r\n" +
							"Propiedades:<br />\r\n- Oficina de ejecutivo del Maze Bank Oeste<br />\r\n- " +
							"Búnker de Paleto de Tráfico de armas<br />\r\n- Falsificación de dinero del " +
							"desierto de Grand Señora<br />\r\n- Sede del club de moteros de Great Chaparral" +
							"<br />\r\n- Apartamento de 1561 San Vitas Street<br />\r\n- Garaje para 10 " +
							"vehículos de 1337 Exceptionalists Way<br />\r\n <br />\r\nVehículos:<br />\r\n- " +
							"Dune FAV <br />\r\n- Maibatsu Frogger<br />\r\n- Enus Windsor<br />\r\n- Obey " +
							"Omnis<br />\r\n- Coquette clásico<br />\r\n- Turismo R<br />\r\n- Pegassi " +
							"Vortex<br />\r\n- Huntley S<br />\r\n- Western Zombie Chopper<br />\r\n- " +
							"Banshee<br />\r\n <br />\r\nArmas, ropa y tatuajes:<br />\r\n- " +
							"Lanzagranadas compacto<br />\r\n- Fusil de tirador<br />\r\n- Fusil compacto<br " +
							"/>\r\n- Indumentarias de carreras acrobáticas e Importación/Exportación, " +
							"tatuajes de motero",
					"El Criminal Enterprise Starter Pack es la forma más rápida que tienen los nuevos " +
							"jugadores de GTA Online de dar impulso a sus imperios criminales. No lo compres si " +
							"ya tienes dicho pack. Accede a varios de los contenidos más emocionantes y famosos de " +
							"GTA Online, que valen más de 10 000 000 de GTA$.",
					"<strong>Mínimo:</strong><br><ul class=\"bb_ul\"><li><strong>SO:</strong> Windows " +
							"10 64 Bit, Windows 8.1 64 Bit, Windows 8 64 Bit, Windows 7 64 Bit Service Pack 1<br>" +
							"</li><li><strong>Procesador:</strong> Intel Core 2 Quad CPU Q6600 @ 2.40GHz (4 CPUs) " +
							"/ AMD Phenom 9850 Quad-Core Processor (4 CPUs) @ 2.5GHz<br></li><li><strong>Memoria:" +
							"</strong> 4 GB de RAM<br></li><li><strong>Gráficos:</strong> NVIDIA 9800 GT 1GB / AMD " +
							"HD 4870 1GB (DX 10, 10.1, 11)<br></li><li><strong>DirectX:</strong> Versión 10<br></li>" +
							"<li><strong>Red:</strong> Conexión de banda ancha a Internet<br></li><li><strong>" +
							"Almacenamiento:</strong> 72 GB de espacio disponible<br></li><li><strong>Tarjeta de " +
							"sonido:</strong> 100% DirectX 10 compatible</li></ul>",
					"<strong>Recomendado:</strong><br><ul class=\"bb_ul\"><li><strong>SO:</strong>" +
							" Windows 10 64 Bit, Windows 8.1 64 Bit, Windows 8 64 Bit, Windows 7 64 Bit Service Pack " +
							"1<br></li><li><strong>Procesador:</strong> Intel Core i5 3470 @ 3.2GHZ (4 CPUs) / AMD " +
							"X8 FX-8350 @ 4GHZ (8 CPUs)<br></li><li><strong>Memoria:</strong> 8 GB de RAM<br></li><li>" +
							"<strong>Gráficos:</strong> NVIDIA GTX 660 2GB / AMD HD7870 2GB<br></li><li><strong>DirectX:" +
							"</strong> Versión 10<br></li><li><strong>Red:</strong> Conexión de banda ancha a Internet<br>" +
							"</li><li><strong>Almacenamiento:</strong> 72 GB de espacio disponible<br></li><li><strong>" +
							"Tarjeta de sonido:</strong> 100% DirectX 10 compatible</li></ul>",
					"Grand Theft Auto V",
					"https://cdn.akamai.steamstatic.com/steam/apps/771300/header.jpg?t=1618851945",
					"http://www.rockstargames.com/V/",
					"https://cdn.akamai.steamstatic.com/steam/apps/771300/page_bg_generated_v6b.jpg?t=1618851945",
					"https://cdn.akamai.steamstatic.com/steam/apps/771300/page_bg_generated.jpg?t=1618851945",
					150D,
					1D,
					12);

			productRepository.save(grandTheftAuto);

			Product callofduty = new Product(
					"El juego más esperado del año y la secuela del juego de acción en primera persona" +
							" número uno en ventas de todos los tiempos, Modern Warfare 2 continúa con la" +
							" tensión y la acción trepidante enfrentando a los jugadores con una nueva amenaza" +
							" decidida a situar al mundo al borde del colapso. <br><br>                             " +
							" Call of Duty®: Modern Warfare 2 incluye por primera vez en un videojuego una " +
							"banda sonora creada por el legendario y galardonado compositor Hans Zimmer, ganador " +
							"de los premios Oscar de la Academia®, Globo de Oro®, Grammy® y Tony. El juego continúa" +
							" los eventos históricos de Call of Duty® 4: Modern Warfare®, la superproducción" +
							" aclamada y premiada mundialmente por la crítica, incluyendo:<br><br>      " +
							" <ul class=><li>&quot;Videojuego Más Jugado Online&quot; de la historia, " +
							"Libro Guinness de los Records 2009<br><br> " +
							"                             </li><li>Más de 50 galardones de Juego del Año," +
							" incluyendo Juego del Año en Consolas y Juego del Año General en 2007, por la Academia" +
							" de la Ciencia y Artes Interactivas®<br><br>                              " +
							"</li></ul><h2 class=\\>COOPERATIVO OPERACIONES ESPECIALES</h2><br>           " +
							"                   Un modo de juego totalmente nuevo que permite juego cooperativo" +
							" online para 2 jugadores que es único respecto a la campaña de un jugador. <br><br> " +
							"                             <ul class=><li>Operaciones Especiales desafía a los " +
							"jugadores en una encerrona de misiones contra reloj y basadas en objetivos.<br><br>" +
							"                              </li><li>Sube de rango a medida que el jugador" +
							" desbloquea nuevas misiones de Operaciones Especiales de dificultad incremental." +
							"<br><br>                              </li><li>Las misiones incluyen partes" +
							" destacadas de la campaña de un jugador, misiones favoritas de los fans de Call of " +
							"Duty 4: Modern Warfare y misiones totalmente nueva y exclusivas.<br><br>            " +
							"                  </li></ul><h2 class=>MULTIJUGADOR REINVENTADO</h2><br>          " +
							"                    Estableciendo un nuevo listón para juego multijugador " +
							"online, el modo multijugador de Modern Warfare 2 proporciona nuevas opciones," +
							" personalización, estadísticas y modos, incluyendo:<br><br>                " +
							"              Crea-una-Clase Evolucionado<br><br>                         " +
							"     <ul class\\\"bb_ul\\\\=\"><li><strong>Armas Secundarias</strong> -" +
							" Pistolas Automáticas, Escopetas, Revólveres, Lanzacohetes<br><br>   " +
							"                           </li><li><strong>Escudos Antidisturbios</strong><br><br>" +
							"                              </li><li><strong>Equipamiento</strong> - Cuchillos " +
							"Arrojadizos, Escudos Antiexplosiones, Inserción Táctica<br><br>              " +
							"                </li><li><strong>Mejoras de Clase</strong><br><br>          " +
							"                    </li><li><strong>Bling (Conexiones Dobles)</strong><br><br>" +
							"                              </li></ul><ul class=\\><li><strong>Rachas de " +
							"Muertes Personalizables</strong> - AC130, Armas Centinela, Misil Predator, " +
							"Counter-UAV, Paquete C.A.R.E.<br><br>                              </li><li>" +
							"<strong>Galardones (Informes de fin de partida)</strong><br><br>          " +
							"                    </li></ul>",
					"El juego más esperado del año y la secuela del juego de acción en primera persona" +
							" número uno en ventas de todos los tiempos, Modern Warfare 2 continúa con " +
							"la tensión y la acción trepidante enfrentando a los jugadores con una nueva " +
							"amenaza decidida a situar al mundo al borde del colapso.",
					"<ul class=\"bb_ul\"><li><strong>SO:</strong> Microsoft Windows XP o" +
							" Windows Vista (Windows 95 / 98 / ME / 2000 no están soportados)<br><br>" +
							"</li><li><strong>Procesador:</strong> Intel Pentium 4 a 3.2 Ghz o AMD " +
							"Athlon 64 3200+ o superior<br><br>   </li><li><strong>Memoria:</strong> 1 " +
							"Gb RAM<br><br> </li><li><strong>Gráficos:</strong> nVidia GeForce 6600GT con " +
							"256 Mb o superior, o ATI Radeon 1600XT o superior<br><br>" +
							"  </li><li><strong>DirectX®:</strong> Microsoft DirectX(R) 9.0c<br><br>" +
							"  </li><li><strong>Disco Duro:</strong> 12 Gb de espacio libre<br><br>  </li><li>" +
							"<strong>Sonido:</strong> 100% compatible con DirectX 9.0c<br><br></li><li><strong>" +
							"Internet:</strong> Conexión de banda ancha para Conectividad Multijugador. Conexión" +
							" a Internet requerida para la activación.<br><br> </li><li><strong>Host de Co-op" +
							" / Multijugador:</strong> Para hospedar partidas Co-op o multijugador, se " +
							"recomienda un procesador dual-core a 2 Ghz o superior.<br><br> </li></ul>",
					"",
					"Call of Duty®: Modern Warfare® 2 (2009)",
					"https://cdn.akamai.steamstatic.com/steam/apps/10180/header.jpg?t=1654809646",
					"https://www.callofduty.com/",
					"https://cdn.akamai.steamstatic.com/steam/apps/10180/page_bg_generated_v6b.jpg?t=1654809646",
					"https://cdn.akamai.steamstatic.com/steam/apps/10180/page.bg.jpg?t=1654809646",
					350D,
					1D,
					8);

			productRepository.save(callofduty);

			Product gross = new Product(
					"Get ready for a thrilling and innovative gaming experience with GROSS, a hybrid " +
							"of tower defense and first person shooter genres. With its fresh and unique " +
							"mechanics, you'll be hooked from the start as you strategize and defend your way " +
							"to victory.<br><br><a href=" +
							"\"https://steamcommunity.com/linkfilter/?url=https://discord.com/invite/HFP5HHG8dg\" " +
							"target=\"_blank\" rel=\" noopener\"  >Join our Discord</a><br><br><img src=" +
							"\"https://cdn.akamai.steamstatic.com/steam/apps/1647420/extras/" +
							"ConstructionV3.gif?t=1673961427\" /><br><br>In GROSS, you are tasked with " +
							"defending your base against waves of enemy attackers in classic tower defense " +
							"fashion. You have the freedom to build barricades and turrets to create mazes and " +
							"launch attacks on the enemy, as well as place traps on the ground for added defense." +
							"<br><br>During the construction phase, you can experiment with different combinations " +
							"of turrets and barriers to come up with the most effective obstacle course for " +
							"your attackers. And don't worry about time limits or wasted resources - you can " +
							"sell everything you build for a full refund until the next combat phase begins. " +
							"So if you love the strategy and satisfaction of building the ultimate tower defense " +
							"setup, GROSS is the game for you!<br><br><img src=\"https://cdn.akamai.steamstatic" +
							".com/steam/apps/1647420/extras/GunsV3.gif?t=1673961427\" /><br><br>Once you are " +
							"done building your defenses, get ready for intense, fast-paced combat! With a " +
							"huge arsenal of guns at your fingertips, each featuring different ammo types, " +
							"you'll have to make split-second decisions to take down waves of zombies. " +
							"Full metal jacket rounds can pierce through multiple enemies and even objects, " +
							"while hollow points send foes flying and give you some breathing room. Incendiary" +
							" rounds ignite zombies and keep them burning, and grenade and rocket launchers " +
							"can deal massive damage to groups of enemies - but watch out, they may also destroy" +
							" valuable cash pickups.<br><br>In addition to all these guns, you'll also have access" +
							" to a range of active abilities that give you even more ways to defeat or distract" +
							" enemies, move around more efficiently, or manage your resources. With over a dozen" +
							" weapons to choose from, gunplay in our game is always exciting and rewarding. Are " +
							"you ready to take on the undead?<br><br><img src=\"https://cdn.akamai.steamstatic" +
							".com/steam/apps/1647420/extras/CashV3.gif?t=1673961427\" /><br><br>Money is essential " +
							"for success. You'll need to gather it from defeated enemies as quickly as possible, " +
							"but beware - you're not the only one after this valuable resource. You'll need to get" +
							" it to safety so you can buy defensive structures and active abilities, and it also" +
							" plays a major role in determining your score.<br><br>GROSS keeps you on your" +
							" toes at all times. Every action you take - or don't take - has consequences. If " +
							"you focus on taking out attackers while your defenses are overwhelmed, you might " +
							"turn the tide of battle, but you'll also risk losing precious money that could be " +
							"used to improve your defenses in the next construction phase. Stay sharp and stay ahead" +
							" of the game to come out on top!",
					"En un mundo donde la codicia ha tomado forma física y ha corrompido al hombre y a la " +
							"máquina, embárcate en un épico viaje por carretera para salvar lo que queda. 100% Tower " +
							"Defense. 100% Shooter en primera persona. Usa tus armas, torretas, trampas y habilidades " +
							"para mantener la línea.",
					"<strong>Mínimo:</strong><br><ul class=\"bb_ul\"><li><strong>SO:</strong> Windows " +
							"10<br></li><li><strong>Procesador:</strong> Quadcore CPU<br></li><li><strong>Memoria:" +
							"</strong> 8 GB de RAM<br></li><li><strong>Gráficos:</strong> Nvidia GeForce GTX 1070/" +
							"1660<br></li><li><strong>DirectX:</strong> Versión 11<br></li><li><strong>" +
							"Almacenamiento:</strong> 7 GB de espacio disponible</li></ul>",
					"\"<strong>Recomendado:</strong><br><ul class=\\\"bb_ul\\\"><li><strong>SO:" +
							"</strong> Windows 10<br></li><li><strong>Procesador:</strong> 6 Core CPU<br></li>" +
							"<li><strong>Memoria:</strong> 8 GB de RAM<br></li><li><strong>Gráficos:</strong> " +
							"Nvidia GeForce RTX2080<br></li><li><strong>DirectX:</strong> Versión 11<br></li>" +
							"<li><strong>Almacenamiento:</strong> 7 GB de espacio disponible</li></ul>\"",
					"GROSS",
					"https://cdn.akamai.steamstatic.com/steam/apps/1647420/header.jpg?t=1673961427",
					"https://hangryowl.games/gross",
					"https://cdn.akamai.steamstatic.com/steam/apps/1647420/page_bg_generated_v6b.jpg?t=1673961427",
					"https://cdn.akamai.steamstatic.com/steam/apps/1647420/page_bg_generated.jpg?t=1673961427",
					1300D,
					1D,
					9
			);

			productRepository.save(gross);

			Product hotline = new Product(
					"\"Hotline Miami 2: Wrong Number es la brutal conclusión de la saga Hotline" +
							" Miami que se desarrolla en plena escalada de violencia y venganza por la " +
							"sangre derramada en el juego original. Sigue la senda de diferentes facciones," +
							" cada cual con sus propios métodos cuestionables y sus motivaciones inciertas," +
							" mientras se van entremezclando consecuencias inesperadas y la realidad, de nuevo, " +
							"se desdibuja en una brillante bruma de neón y sangre.<br><br>El cruento combate" +
							" contra una severa oposición te exigirá una intensa concentración para dominar " +
							"variables, armas y métodos de ejecución novedosos según se desarrolla la lucha." +
							" Déjate cautivar por los impactantes colores de un estilo gráfico inconfundible" +
							" mientras aniquilas a todo aquel que se interponga en tu camino para desvelar " +
							"el significado de la masacre. Es la parada final, el fin indiscutible.<br><br>" +
							"Infinitas hostilidades - Ajusta tus técnicas de combate a los cambios de narrativa" +
							" entre facciones y familiarízate con variaciones únicas empleando nuevas armas y " +
							"más movimientos y ataques cuerpo a cuerpo.<br><br>Una fascinante banda sonora -" +
							" Más de cuarenta potentes temas de decenas de artistas ambientan el salvaje conflicto" +
							" y dan relieve a la dimensión de tus acciones. Nuevos artistas se unen a favoritos " +
							"ya clásicos como M|O|O|N, Perturbator, Jasper Byrne, Scattle y El Huervo para " +
							"brindarte una increíble masacre sonora. <br><br>Editor de niveles personalizados " +
							"- Diseña niveles personalizados usando personajes, enemigos, armas y temas " +
							"musicales del juego y comparte tus creaciones online. [DISPONIBLE EN PRIMAVERA " +
							"DE 2015]<h2 class=\\\"bb_tag\\\">Hotline Miami 2: Wrong Number Digital Special " +
							"Edition</h2><br>The Hotline Miami 2: Wrong Number Digital Special Edition includes" +
							" the Hotline Miami 2 Wrong Number Remix EP featuring six remixed tracks from M|O|O|N" +
							", Scattle, and Carpenter Brut.<br><br><img src=\\\"https://cdn.akamai.steamstatic" +
							".com/steam/apps/274170/extras/RemixEPBanner.jpg?t=1659054816\\\" /><h2 class=\\\"" +
							"bb_tag\\\">Hotline Miami 2: Wrong Number Payday 2 Packs</h2><br>The Hotline Miami " +
							"2: Wrong Number Digital Special Edition also includes free access to the Payday 2 " +
							"&quot;Jacket Character Pack&quot; that includes the character items and weapons " +
							"below.<br><br><img src=\\\"https://cdn.akamai.steamstatic.com/steam/apps/274170/" +
							"extras/PD2JacketBanner.png?t=1659054816\\\" /><br><br>All owners of Hotline Miami" +
							" 2: Wrong Number on Steam - standard or Special Edition - will receive an exclusive" +
							" mask pack in Payday 2.<br><br><img src=\\\"https://cdn.akamai.steamstatic.com/steam" +
							"/apps/274170/extras/PD2MasksBanner.png?t=1659054816\\\" />\"",
					"Hotline Miami 2: Wrong Number es la brutal conclusión de la saga Hotline " +
							"Miami que se desarrolla en plena escalada de violencia y venganza por la sangre" +
							" derramada en el juego original.",
					"<strong>Mínimo:</strong><br><ul class=\"bb_ul\"><li><strong>SO:</strong> Microsoft®" +
							" Windows® Vista / 7 / 8<br></li><li><strong>Procesador:</strong> 2.4 GHz Intel Core " +
							"2 Duo or better<br></li><li><strong>Memoria:</strong> 1 GB de RAM<br></li><li>" +
							"<strong>Gráficos:</strong> OpenGL 3.2 compatible GPU with at least 256MB of VRAM<br>" +
							"</li><li><strong>DirectX:</strong> Versión 9.0c<br></li><li><strong>Almacenamiento" +
							":</strong> 600 MB de espacio disponible<br></li><li><strong>Notas adicionales:" +
							"</strong> PS4 or Xbox 360 Controller or Direct Input compatible controller</li></ul>",
					"<strong>Recomendado:</strong><br><ul class=\"bb_ul\"><li><strong>SO:</strong> " +
							"Microsoft® Windows® Vista / 7 / 8<br></li><li><strong>Procesador:</strong> 2.8 GHz" +
							" Intel Core 2 Duo or better<br></li><li><strong>Memoria:</strong> 2 GB de RAM<br>" +
							"</li><li><strong>Gráficos:</strong> OpenGL 3.2 compatible GPU with at least 512MB" +
							" of VRAM<br></li><li><strong>DirectX:</strong> Versión 9.0c<br></li><li><strong>" +
							"Almacenamiento:</strong> 600 MB de espacio disponible<br></li><li><strong>Notas" +
							" adicionales:</strong> PS4 or Xbox 360 Controller or Direct Input compatible " +
							"controller</li></ul>",
					"Hotline Miami 2: Wrong Number",
					"https://cdn.akamai.steamstatic.com/steam/apps/274170/header.jpg?t=1659054816",
					"http://www.hotlinemiami.com",
					"https://cdn.akamai.steamstatic.com/steam/apps/274170/page_bg_generated_v6b.jpg?t=1659054816",
					"https://cdn.akamai.steamstatic.com/steam/apps/274170/page_bg_generated.jpg?t=1659054816",
					1050D,
					1D,
					5
			);

			productRepository.save(hotline);

			Product loneruin = new Product(
					"<a href=\"https://steamcommunity.com/linkfilter/?url=https://discord.gg/2UnEbEq\"" +
							" target=\"_blank\" rel=\" noopener\"  ><img src=\"https://cdn.akamai.steamstatic." +
							"com/steam/apps/1452070/extras/Discord-Title.jpg?t=1674492641\" /></a><br><br>Lone" +
							" Ruin es un roguelike <strong>twin-stick shooter</strong> basado en hechizos y " +
							"centrado en la rejugabilidad. Métete en la piel de un explorador en busca de un " +
							"misterioso poder ancestral y adéntrate en una ciudad mágica en ruinas, construida " +
							"sobre una fuente de magia que usaban los antiguos magos para potenciarse y " +
							"transformarse. Adéntrate cada vez más mientras luchas contra criaturas retorcidas" +
							" y utilizas tus propias habilidades mágicas para llegar al centro de la ruina " +
							"solitaria.<br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1452070" +
							"/extras/LR-A_city_corrupted.png?t=1674492641\" /><br><img src=\"https://cdn.akamai" +
							".steamstatic.com/steam/apps/1452070/extras/LR-gif2.gif?t=1674492641\" /><br>Una " +
							"ciudad ancestral envuelta por la magia. En lo que una vez fue una ajetreada " +
							"civilización y un pueblo que vivía en armonía con la magia que les rodeaba, hace" +
							" tiempo que vagan irreconocibles criaturas a las que la magia ha retorcido y hecho" +
							" enloquecer. ¿Qué ha podido corromper a esta ciudad? Habiendo escuchado las leyendas" +
							", tú, un talentoso explorador hechicero, llegas a estas hostiles ruinas un milenio" +
							" después con el objetivo de hallar el antiguo poder y acabar finalmente con la " +
							"corrupción que ha consumido a la ciudad desde hace tantos años. La respuesta " +
							"probablemente esté en el centro de la ruina solitaria... <i>si es que consigues llegar" +
							" hasta allí.</i><br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1452" +
							"070/extras/LR-Outlive_the_ruins.png?t=1674492641\" /><br><img src=\"https://cdn.akamai" +
							".steamstatic.com/steam/apps/1452070/extras/LR-gif4.gif?t=1674492641\" /><br>Lucha en" +
							" batallas sangrientas contra un montón de enemigos y múltiples jefes en distintas " +
							"zonas dinámicas e infernales. ¡No dejes que las horripilantes criaturas se apoderen" +
							" de ti!<br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1452070/extr" +
							"as/LR-Spells_aplenty.png?t=1674492641\" /><br><img src=\"https://cdn.akamai.steamstati" +
							"c.com/steam/apps/1452070/extras/LR-gif1.gif?t=1674492641\" /><br>Ir en solitario es" +
							" peligroso, así que elige el hechizo que mejor se adapte a tu estilo de juego para" +
							" sobrevivir a los peligros de Lone Ruin. Maximiza tu combinación de configuración " +
							"mágica destructiva gracias a las numerosas mejoras y opciones de personalización" +
							" disponibles a medida que eliges un camino por el que adentrarte en las ruinas.<br>" +
							"<br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1452070/extras/LR-Surv" +
							"ive_the_chaos.png?t=1674492641\" /><br><img src=\"https://cdn.akamai.steamstatic.com/" +
							"steam/apps/1452070/extras/LR-gif5.gif?t=1674492641\" /><br>¿En busca de un desafío " +
							"diferente? Elige el modo supervivencia para enfrentarte a una partida cronometrada y" +
							" basada en oleadas. ¿Cuánto tiempo eres capaz de sobrevivir contra la dificultad " +
							"creciente y los enemigos cada vez más duros?",
					"Adéntrate en una antigua ruina mágica en busca de un poder ancestral en este" +
							" roguelike twin-stick shooter con alta rejugabilidad. Aprovecha al máximo tus hechizos" +
							" y crea combinaciones definitivas para derrotar a las monstruosidades retorcidas y" +
							" acceder a las profundidades de la ruina solitaria.",
					"<strong>Mínimo:</strong><br><ul class=\"bb_ul\"><li>Requiere un procesador y un " +
							"sistema operativo de 64 bits<br></li><li><strong>SO:</strong> Windows XP, Vista, 7, 8," +
							" or 10<br></li><li><strong>Procesador:</strong> 2.0 ghz<br></li><li><strong>Memoria:</" +
							"strong> 2 MB de RAM<br></li><li><strong>Gráficos:</strong> 128MB<br></li><li><strong>" +
							"Almacenamiento:</strong> 44 MB de espacio disponible</li></ul>",
					"<strong>Recomendado:</strong><br><ul class=\"bb_ul\"><li>Requiere un " +
							"procesador y un sistema operativo de 64 bits</li></ul>",
					"LONE RUIN",
					"https://cdn.akamai.steamstatic.com/steam/apps/1452070/header.jpg?t=1674492641",
					"http://www.superrareoriginals.com/",
					"https://cdn.akamai.steamstatic.com/steam/apps/1452070/page_bg_generated_v6b.jpg?t=1674492641",
					"https://cdn.akamai.steamstatic.com/steam/apps/1452070/page.bg.jpg?t=1674492641",
					180D,
					1D,
					20
			);*/

//			productRepository.save(loneruin);
		};
	}
}
