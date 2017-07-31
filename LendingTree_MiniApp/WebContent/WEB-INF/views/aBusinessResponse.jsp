<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.net.URL"%>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
<script type="text/javascript" src="jquery.js"></script>
 <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/demo/demo.css">
    <script type="text/javascript" src="jquery-easyui-1.5/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.5/jquery.easyui.min.js"></script>
<script type="text/javascript">
   function getStates(country)
{
    
    	var states=new Array();
    	if(country=='Argentina'){
    	states=new Array();
    		states = new Array("Buenos Aires", "Buenos Aires Capital", "Catamarca", "Chaco", "Chubut", "Cordoba", "Corrientes", "Entre Rios", "Formosa", "Jujuy", "La Pampa", "La Rioja", "Mendoza", "Misiones", "Neuquen", "Rio Negro", "Salta", "San Juan", "San Luis", "Santa Cruz", "Santa Fe", "Santiago del Estero", "Tierra del Fuego", "Tucuman");
    	}else if(country=='Australia'){
    	states=new Array();
    		states = new Array("Capital Territory", "New South Wales", "Northern Territory", "Queensland", "South Australia", "Tasmania", "Victoria", "Western Australia");
    	}else if(country=='Austria'){
    	states=new Array();
    		states = new Array("Burgenland", "Kaernten", "Niederoesterreich", "Oberoesterreich", "Salzburg", "Steiermark", "Tirol", "Vorarlberg", "Wien");
    	}else if(country=='Azerbaijan'){
    	states=new Array();
			states = new Array("Abseron Rayonu", "Agcabadi Rayonu", "Agdam Rayonu", "Agdas Rayonu", "Agstafa Rayonu", "Agsu Rayonu", "Astara Rayonu", "Balakan Rayonu", "Barda Rayonu", "Beylaqan Rayonu", "Bilasuvar Rayonu", "Cabrayil Rayonu", "Calilabad Rayonu", "Daskasan Rayonu", "Davaci Rayonu", "Fuzuli Rayonu", "Gadabay Rayonu", "Goranboy Rayonu", "Goycay Rayonu", "Haciqabul Rayonu", "Imisli Rayonu", "Ismayilli Rayonu", "Kalbacar Rayonu", "Kurdamir Rayonu", "Lacin Rayonu", "Lankaran Rayonu", "Lerik Rayonu", "Masalli Rayonu", "Neftcala Rayonu", "Oguz Rayonu", "Qabala Rayonu", "Qax Rayonu", "Qazax Rayonu", "Qobustan Rayonu", "Quba Rayonu", "Qubadli Rayonu", "Qusar Rayonu", "Saatli Rayonu", "Sabirabad Rayonu", "Saki Rayonu", "Salyan Rayonu", "Samaxi Rayonu", "Samkir Rayonu", "Samux Rayonu", "Siyazan Rayonu", "Susa Rayonu", "Tartar Rayonu", "Tovuz Rayonu", "Ucar Rayonu", "Xacmaz Rayonu", "Xanlar Rayonu", "Xizi Rayonu", "Xocali Rayonu", "Xocavand Rayonu", "Yardimli Rayonu", "Yevlax Rayonu", "Zangilan Rayonu", "Zaqatala Rayonu", "Zardab Rayonu", "Ali Bayramli Sahari", "Baki Sahari", "Ganca Sahari", "Lankaran Sahari", "Mingacevir Sahari", "Naftalan Sahari", "Saki Sahari", "Sumqayit Sahari", "Susa Sahari", "Xankandi Sahari", "Yevlax Sahari", "Naxcivan Muxtar");
    	}else if(country=='Belgium'){
    	states=new Array();
    		states = new Array("Antwerpen", "Brabant Wallon", "Brussels", "Flanders", "Hainaut", "Liege", "Limburg", "Luxembourg", "Namur", "Oost-Vlaanderen", "Vlaams-Brabant", "Wallonia", "West-Vlaanderen");
    	}else if(country=='Brazil'){
    	states=new Array();
    		states = new Array("Acre", "Alagoas", "Amapa", "Amazonas", "Bahia", "Ceara", "Distrito Federal", "Espirito Santo", "Goias", "Maranhao", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Para", "Paraiba", "Parana", "Pernambuco", "Piaui", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondonia", "Roraima", "Santa Catarina", "Sao Paulo", "Sergipe", "Tocantins");
    	}else if(country=='Burma'){
    	states=new Array();
    		states = new Array("Ayeyarwady", "Bago", "Magway", "Mandalay", "Sagaing", "Tanintharyi", "Yangon", "Chin State", "Kachin State", "Kayin State", "Kayah State", "Mon State", "Rakhine State", "Shan State");
    	}else if(country=='Cameroon'){
    	states=new Array();
    		states = new Array("Adamaoua", "Centre", "Est", "Extreme-Nord", "Littoral", "Nord", "Nord-Ouest", "Ouest", "Sud", "Sud-Ouest");
    	}else if(country=='Canada'){
    	states=new Array();
    		states = new Array("Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland and Labrador", "Northwest Territories", "Nova Scotia", "Nunavut", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan", "Yukon Territory");
    	}else if(country=='Chile'){
    	states=new Array();
    		states = new Array("Aysen", "Antofagasta", "Araucania", "Atacama", "Bio-Bio", "Coquimbo", "O'Higgins", "Los Lagos", "Magallanes y la Antartica Chilena", "Maule", "Santiago Region Metropolitana", "Tarapaca", "Valparaiso");
    	}else if(country=='China'){
    	states=new Array();
    		states = new Array("Anhui", "Fujian", "Gansu", "Guangdong", "Guizhou", "Hainan", "Hebei", "Heilongjiang", "Henan", "Hubei", "Hunan", "Jiangsu", "Jiangxi", "Jilin", "Liaoning", "Qinghai", "Shaanxi", "Shandong", "Shanxi", "Sichuan", "Yunnan", "Zhejiang", "Guangxi", "Nei Mongol", "Ningxia", "Xinjiang", "Xizang (Tibet)", "Beijing", "Chongqing", "Shanghai", "Tianjin");
    	}else if(country=='Colombia'){
    	states=new Array();
    		states = new Array("Amazonas", "Antioquia", "Arauca", "Atlantico", "Bogota District Capital", "Bolivar", "Boyaca", "Caldas", "Caqueta", "Casanare", "Cauca", "Cesar", "Choco", "Cordoba", "Cundinamarca", "Guainia", "Guaviare", "Huila", "La Guajira", "Magdalena", "Meta", "Narino", "Norte de Santander", "Putumayo", "Quindio", "Risaralda", "San Andres & Providencia", "Santander", "Sucre", "Tolima", "Valle del Cauca", "Vaupes", "Vichada");
    	}else if(country=='Costa Rica'){
    	states=new Array();
    		states = new Array("Alajuela", "Cartago", "Guanacaste", "Heredia", "Limon", "Puntarenas", "San Jose");
    	}else if(country=='Czech Republic'){
    	states=new Array();
    		states = new Array("Jihocesky Kraj", "Jihomoravsky Kraj", "Karlovarsky Kraj", "Kralovehradecky Kraj", "Liberecky Kraj", "Moravskoslezsky Kraj", "Olomoucky Kraj", "Pardubicky Kraj", "Plzensky Kraj", "Praha", "Stredocesky Kraj", "Ustecky Kraj", "Vysocina", "Zlinsky Kraj");
    	}else if(country=='Denmark'){
    	states=new Array();
    		states = new Array("Arhus", "Bornholm", "Frederiksberg", "Frederiksborg", "Fyn", "Kobenhavn", "Kobenhavns", "Nordjylland", "Ribe", "Ringkobing", "Roskilde", "Sonderjylland", "Storstrom", "Vejle", "Vestsjalland", "Viborg");
    	}else if(country=='Dominican Republic'){
    	states=new Array();
    		states = new Array("Azua", "Baoruco", "Barahona", "Dajabon", "Distrito Nacional", "Duarte", "Elias Pina", "El Seibo", "Espaillat", "Hato Mayor", "Independencia", "La Altagracia", "La Romana", "La Vega", "Maria Trinidad Sanchez", "Monsenor Nouel", "Monte Cristi", "Monte Plata", "Pedernales", "Peravia", "Puerto Plata", "Salcedo", "Samana", "Sanchez Ramirez", "San Cristobal", "San Jose de Ocoa", "San Juan", "San Pedro de Macoris", "Santiago", "Santiago Rodriguez", "Santo Domingo", "Valverde");
    	}else if(country=='Egypt'){
    	states=new Array();
    		states = new Array("Ad Daqahliyah", "Al Bahr al Ahmar", "Al Buhayrah", "Al Fayyum", "Al Gharbiyah", "Al Iskandariyah", "Al Isma'iliyah", "Al Jizah", "Al Minufiyah", "Al Minya", "Al Qahirah", "Al Qalyubiyah", "Al Wadi al Jadid", "Ash Sharqiyah", "As Suways", "Aswan", "Asyut", "Bani Suwayf", "Bur Sa'id", "Dumyat", "Janub Sina'", "Kafr ash Shaykh", "Matruh", "Qina", "Shamal Sina'", "Suhaj");
    	}else if(country=='El Salvador'){
    	states=new Array();
    		states = new Array("Ahuachapan", "Cabanas", "Chalatenango", "Cuscatlan", "La Libertad", "La Paz", "La Union", "Morazan", "San Miguel", "San Salvador", "Santa Ana", "San Vicente", "Sonsonate", "Usulutan");
    	}else if(country=='Finland'){
    	states=new Array();
    		states = new Array("Aland", "Etela-Suomen Laani", "Ita-Suomen Laani", "Lansi-Suomen Laani", "Lappi", "Oulun Laani");
    	}else if(country=='France'){
    	states=new Array();
    		states = new Array("Alsace", "Aquitaine", "Auvergne", "Basse-Normandie", "Bourgogne", "Bretagne", "Centre", "Champagne-Ardenne", "Corse", "Franche-Comte", "Haute-Normandie", "Ile-de-France", "Languedoc-Roussillon", "Limousin", "Lorraine", "Midi-Pyrenees", "Nord-Pas-de-Calais", "Pays de la Loire", "Picardie", "Poitou-Charentes", "Provence-Alpes-Cote d'Azur", "Rhone-Alpes");
    	}else if(country=='Germany'){
    	states=new Array();
    		states = new Array("Baden-Wuerttemberg", "Bayern", "Berlin", "Brandenburg", "Bremen", "Hamburg", "Hessen", "Mecklenburg-Vorpommern", "Niedersachsen", "Nordrhein-Westfalen", "Rheinland-Pfalz", "Saarland", "Sachsen", "Sachsen-Anhalt", "Schleswig-Holstein", "Thueringen");
    	}else if(country=='Greenland'){
    	states=new Array();
    		states = new Array("Avannaa (Nordgronland)", "Tunu (Ostgronland)", "Kitaa (Vestgronland)");
    	}else if(country=='Honduras'){
    	states=new Array();
    		states = new Array("Atlantida", "Choluteca", "Colon", "Comayagua", "Copan", "Cortes", "El Paraiso", "Francisco Morazan", "Gracias a Dios", "Intibuca", "Islas de la Bahia", "La Paz", "Lempira", "Ocotepeque", "Olancho", "Santa Barbara", "Valle", "Yoro");
    	}else if(country=='Hungary'){
    	states=new Array();
    		states = new Array("Bacs-Kiskun", "Baranya", "Bekes", "Borsod-Abauj-Zemplen", "Csongrad", "Fejer", "Gyor-Moson-Sopron", "Hajdu-Bihar", "Heves", "Jasz-Nagykun-Szolnok", "Komarom-Esztergom", "Nograd", "Pest", "Somogy", "Szabolcs-Szatmar-Bereg", "Tolna", "Vas", "Veszprem", "Zala", "Bekescsaba", "Debrecen", "Dunaujvaros", "Eger", "Gyor", "Hodmezovasarhely", "Kaposvar", "Kecskemet", "Miskolc", "Nagykanizsa", "Nyiregyhaza", "Pecs", "Sopron", "Szeged", "Szekesfehervar", "Szolnok", "Szombathely", "Tatabanya", "Veszprem", "Zalaegerszeg");
    	}else if(country=='India'){
    	states=new Array();
    		states = new Array("Andaman and Nicobar Islands", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chandigarh", "Chhattisgarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Lakshadweep", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa", "Pondicherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telengana","Tripura", "Uttaranchal", "Uttar Pradesh", "West Bengal");
    	}else if(country=='Indonesia'){
    	states=new Array();
    		states = new Array("Aceh", "Bali", "Banten", "Bengkulu", "Gorontalo", "Irian Jaya Barat", "Jakarta Raya", "Jambi", "Jawa Barat", "Jawa Tengah", "Jawa Timur", "Kalimantan Barat", "Kalimantan Selatan", "Kalimantan Tengah", "Kalimantan Timur", "Kepulauan Bangka Belitung", "Kepulauan Riau", "Lampung", "Maluku", "Maluku Utara", "Nusa Tenggara Barat", "Nusa Tenggara Timur", "Papua", "Riau", "Sulawesi Barat", "Sulawesi Selatan", "Sulawesi Tengah", "Sulawesi Tenggara", "Sulawesi Utara", "Sumatera Barat", "Sumatera Selatan", "Sumatera Utara", "Yogyakarta");
    	}else if(country=='IreLand'){
    	states=new Array();
    		states = new Array("Carlow", "Cavan", "Clare", "Cork", "Donegal", "Dublin", "Galway", "Kerry", "Kildare", "Kilkenny", "Laois", "Leitrim", "Limerick", "Longford", "Louth", "Mayo", "Meath", "Monaghan", "Offaly", "Roscommon", "Sligo", "Tipperary", "Waterford", "Westmeath", "Wexford", "Wicklow");
    	}else if(country=='Israel'){
    	states=new Array();
    		states = new Array("Central", "Haifa", "Jerusalem", "Northern", "Southern", "Tel Aviv");
    	}else if(country=='Italy'){
    	states=new Array();
    		states = new Array("Abruzzo", "Basilicata", "Calabria", "Campania", "Emilia-Romagna", "Friuli-Venezia Giulia", "Lazio", "Liguria", "Lombardia", "Marche", "Molise", "Piemonte", "Puglia", "Sardegna", "Sicilia", "Toscana", "Trentino-Alto Adige", "Umbria", "Valle d'Aosta", "Veneto");
    	}else if(country=='Japan'){
    	states=new Array();
    		states = new Array("Aichi", "Akita", "Aomori", "Chiba", "Ehime", "Fukui", "Fukuoka", "Fukushima", "Gifu", "Gumma", "Hiroshima", "Hokkaido", "Hyogo", "Ibaraki", "Ishikawa", "Iwate", "Kagawa", "Kagoshima", "Kanagawa", "Kochi", "Kumamoto", "Kyoto", "Mie", "Miyagi", "Miyazaki", "Nagano", "Nagasaki", "Nara", "Niigata", "Oita", "Okayama", "Okinawa", "Osaka", "Saga", "Saitama", "Shiga", "Shimane", "Shizuoka", "Tochigi", "Tokushima", "Tokyo", "Tottori", "Toyama", "Wakayama", "Yamagata", "Yamaguchi", "Yamanashi");
    	}else if(country=='Kazakhstan'){
    	states=new Array();
    		states = new Array("Almaty Oblysy", "Almaty Qalasy", "Aqmola Oblysy", "Aqtobe Oblysy", "Astana Qalasy", "Atyrau Oblysy", "Batys Qazaqstan Oblysy", "Bayqongyr Qalasy", "Mangghystau Oblysy", "Ongtustik Qazaqstan Oblysy", "Pavlodar Oblysy", "Qaraghandy Oblysy", "Qostanay Oblysy", "Qyzylorda Oblysy", "Shyghys Qazaqstan Oblysy", "Soltustik Qazaqstan Oblysy", "Zhambyl Oblysy");
    	}else if(country=='Kenya'){
    	states=new Array();
    		states = new Array("Central", "Coast", "Eastern", "Nairobi Area", "North Eastern", "Nyanza", "Rift Valley", "Western");
    	}else if(country=='Kuwait'){
    	states=new Array();
    		states = new Array("Central", "Coast", "Eastern", "Nairobi Area", "North Eastern", "Nyanza", "Rift Valley", "Western");
    	}else if(country=='Luxemburg'){
    	states=new Array();
    		states = new Array("Diekirch", "Grevenmacher", "Luxembourg");
    	}else if(country=='Malaysia'){
    	states=new Array();
    		states = new Array("Johor", "Kedah", "Kelantan", "Kuala Lumpur", "Labuan", "Malacca", "Negeri Sembilan", "Pahang", "Perak", "Perlis", "Penang", "Sabah", "Sarawak", "Selangor", "Terengganu");
    	}else if(country=='Mexico'){
    	states=new Array();
    		states = new Array("Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Coahuila de Zaragoza", "Colima", "Distrito Federal", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Mexico", "Michoacan de Ocampo", "Morelos", "Nayarit", "Nuevo Leon", "Oaxaca", "Puebla", "Queretaro de Arteaga", "Quintana Roo", "San Luis Potosi", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz-Llave", "Yucatan", "Zacatecas");
    	}else if(country=='Morocco'){
    	states=new Array();
    		states = new Array("Agadir", "Al Hoceima", "Azilal", "Beni Mellal", "Ben Slimane", "Boulemane", "Casablanca", "Chaouen", "El Jadida", "El Kelaa des Sraghna", "Er Rachidia", "Essaouira", "Fes", "Figuig", "Guelmim", "Ifrane", "Kenitra", "Khemisset", "Khenifra", "Khouribga", "Laayoune", "Larache", "Marrakech", "Meknes", "Nador", "Ouarzazate", "Oujda", "Rabat-Sale", "Safi", "Settat", "Sidi Kacem", "Tangier", "Tan-Tan", "Taounate", "Taroudannt", "Tata", "Taza", "Tetouan", "Tiznit");
    	}else if(country=='Madagascar'){
    	states=new Array();
    		states = new Array("Antananarivo", "Antsiranana", "Fianarantsoa", "Mahajanga", "Toamasina", "Toliara");
    	}else if(country=='Netherlands'){
    	states=new Array();
    		states = new Array("Drenthe", "Flevoland", "Friesland", "Gelderland", "Groningen", "Limburg", "Noord-Brabant", "Noord-Holland", "Overijssel", "Utrecht", "Zeeland", "Zuid-Holland");
    	}else if(country=='New Zealand'){
    	states=new Array();
    		states = new Array("Auckland", "Bay of Plenty", "Canterbury", "Chatham Islands", "Gisborne", "Hawke's Bay", "Manawatu-Wanganui", "Marlborough", "Nelson", "Northland", "Otago", "Southland", "Taranaki", "Tasman", "Waikato", "Wellington", "West Coast");
    	}else if(country=='Nigeria'){
    	states=new Array();
    		states = new Array("Abia", "Abuja Federal Capital", "Adamawa", "Akwa Ibom", "Anambra", "Bauchi", "Bayelsa", "Benue", "Borno", "Cross River", "Delta", "Ebonyi", "Edo", "Ekiti", "Enugu", "Gombe", "Imo", "Jigawa", "Kaduna", "Kano", "Katsina", "Kebbi", "Kogi", "Kwara", "Lagos", "Nassarawa", "Niger", "Ogun", "Ondo", "Osun", "Oyo", "Plateau", "Rivers", "Sokoto", "Taraba", "Yobe", "Zamfara");
    	}else if(country=='Norway'){
    	states=new Array();
    		states = new Array("Akershus", "Aust-Agder", "Buskerud", "Finnmark", "Hedmark", "Hordaland", "More og Romsdal", "Nordland", "Nord-Trondelag", "Oppland", "Oslo", "Ostfold", "Rogaland", "Sogn og Fjordane", "Sor-Trondelag", "Telemark", "Troms", "Vest-Agder", "Vestfold");
    	}else if(country=='Pakistan'){
    	states=new Array();
    		states = new Array("Balochistan", "North-West Frontier Province", "Punjab", "Sindh", "Islamabad Capital Territory", "Federally Administered Tribal Areas");
    	}else if(country=='Panama'){
    	states=new Array();
    		states = new Array("Bocas del Toro", "Chiriqui", "Cocle", "Colon", "Darien", "Herrera", "Los Santos", "Panama", "San Blas", "Veraguas");
    	}else if(country=='Peru'){
    	states=new Array();
    		states = new Array("Amazonas", "Ancash", "Apurimac", "Arequipa", "Ayacucho", "Cajamarca", "Callao", "Cusco", "Huancavelica", "Huanuco", "Ica", "Junin", "La Libertad", "Lambayeque", "Lima", "Loreto", "Madre de Dios", "Moquegua", "Pasco", "Piura", "Puno", "San Martin", "Tacna", "Tumbes", "Ucayali");
    	}else if(country=='Philippines'){
    	states=new Array();
    		states = new Array("Abra", "Agusan del Norte", "Agusan del Sur", "Aklan", "Albay", "Antique", "Apayao", "Aurora", "Basilan", "Bataan", "Batanes", "Batangas", "Biliran", "Benguet", "Bohol", "Bukidnon", "Bulacan", "Cagayan", "Camarines Norte", "Camarines Sur", "Camiguin", "Capiz", "Catanduanes", "Cavite", "Cebu", "Compostela", "Davao del Norte", "Davao del Sur", "Davao Oriental", "Eastern Samar", "Guimaras", "Ifugao", "Ilocos Norte", "Ilocos Sur", "Iloilo", "Isabela", "Kalinga", "Laguna", "Lanao del Norte", "Lanao del Sur", "La Union", "Leyte", "Maguindanao", "Marinduque", "Masbate", "Mindoro Occidental", "Mindoro Oriental", "Misamis Occidental", "Misamis Oriental", "Mountain Province", "Negros Occidental", "Negros Oriental", "North Cotabato", "Northern Samar", "Nueva Ecija", "Nueva Vizcaya", "Palawan", "Pampanga", "Pangasinan", "Quezon", "Quirino", "Rizal", "Romblon", "Samar", "Sarangani", "Siquijor", "Sorsogon", "South Cotabato", "Southern Leyte", "Sultan Kudarat", "Sulu", "Surigao del Norte", "Surigao del Sur", "Tarlac", "Tawi-Tawi", "Zambales", "Zamboanga del Norte", "Zamboanga del Sur", "Zamboanga Sibugay");
    	}else if(country=='Poland'){
    	states=new Array();
    		states = new Array("Greater Poland (Wielkopolskie)", "Kuyavian-Pomeranian (Kujawsko-Pomorskie)", "Lesser Poland (Malopolskie)", "Lodz (Lodzkie)", "Lower Silesian (Dolnoslaskie)", "Lublin (Lubelskie)", "Lubusz (Lubuskie)", "Masovian (Mazowieckie)", "Opole (Opolskie)", "Podlasie (Podlaskie)", "Pomeranian (Pomorskie)", "Silesian (Slaskie)", "Subcarpathian (Podkarpackie)", "Swietokrzyskie (Swietokrzyskie)", "Warmian-Masurian (Warminsko-Mazurskie)", "West Pomeranian (Zachodniopomorskie)");
    	}else if(country=='Portugal'){
    	states=new Array();
    		states = new Array("Aveiro", "Acores", "Beja", "Braga", "Braganca", "Castelo Branco", "Coimbra", "Evora", "Faro", "Guarda", "Leiria", "Lisboa", "Madeira", "Portalegre", "Porto", "Santarem", "Setubal", "Viana do Castelo", "Vila Real", "Viseu");
    	}else if(country=='Romania'){
    	states=new Array();
    		states = new Array("Alba", "Arad", "Arges", "Bacau", "Bihor", "Bistrita-Nasaud", "Botosani", "Braila", "Brasov", "Bucuresti", "Buzau", "Calarasi", "Caras-Severin", "Cluj", "Constanta", "Covasna", "Dimbovita", "Dolj", "Galati", "Gorj", "Giurgiu", "Harghita", "Hunedoara", "Ialomita", "Iasi", "Ilfov", "Maramures", "Mehedinti", "Mures", "Neamt", "Olt", "Prahova", "Salaj", "Satu Mare", "Sibiu", "Suceava", "Teleorman", "Timis", "Tulcea", "Vaslui", "Vilcea", "Vrancea");
    	}else if(country=='Russia'){
    	states=new Array();
    		states = new Array("Amur", "Arkhangel'sk", "Astrakhan'", "Belgorod", "Bryansk", "Chelyabinsk", "Chita", "Irkutsk", "Ivanovo", "Kaliningrad", "Kaluga", "Kamchatka", "Kemerovo", "Kirov", "Kostroma", "Kurgan", "Kursk", "Leningrad", "Lipetsk", "Magadan", "Moscow", "Murmansk", "Nizhniy Novgorod", "Novgorod", "Novosibirsk", "Omsk", "Orenburg", "Orel", "Penza", "Perm'", "Pskov", "Rostov", "Ryazan'", "Sakhalin", "Samara", "Saratov", "Smolensk", "Sverdlovsk", "Tambov", "Tomsk", "Tula", "Tver'", "Tyumen'", "Ul'yanovsk", "Vladimir", "Volgograd", "Vologda", "Voronezh", "Yaroslavl'", "Adygeya", "Altay", "Bashkortostan", "Buryatiya", "Chechnya", "Chuvashiya", "Dagestan", "Ingushetiya", "Kabardino-Balkariya", "Kalmykiya", "Karachayevo-Cherkesiya", "Kareliya", "Khakasiya", "Komi", "Mariy-El", "Mordoviya", "Sakha", "North Ossetia", "Tatarstan", "Tyva", "Udmurtiya", "Aga Buryat", "Chukotka", "Evenk", "Khanty-Mansi", "Komi-Permyak", "Koryak", "Nenets", "Taymyr", "Ust'-Orda Buryat", "Yamalo-Nenets", "Altay", "Khabarovsk", "Krasnodar", "Krasnoyarsk", "Primorskiy", "Stavropol'", "Moscow", "St. Petersburg", "Yevrey");
    	}else if(country=='Saudi Arabia'){
    	states=new Array();
    		states = new Array("Al Bahah", "Al Hudud ash Shamaliyah", "Al Jawf", "Al Madinah", "Al Qasim", "Ar Riyad", "Ash Sharqiyah", "'Asir", "Ha'il", "Jizan", "Makkah", "Najran", "Tabuk");
    	}else if(country=='South Africa'){
    	states=new Array();
    		states = new Array("Eastern Cape", "Free State", "Gauteng", "KwaZulu-Natal", "Limpopo", "Mpumalanga", "North-West", "Northern Cape", "Western Cape");
    	}else if(country=='Spain'){
    	states=new Array();
    		states = new Array("Andalucia", "Aragon", "Asturias", "Baleares", "Ceuta", "Canarias", "Cantabria", "Castilla-La Mancha", "Castilla y Leon", "Cataluna", "Comunidad Valenciana", "Extremadura", "Galicia", "La Rioja", "Madrid", "Melilla", "Murcia", "Navarra", "Pais Vasco");
    	}else if(country=='Sri Lanka'){
    	states=new Array();
    		states = new Array("Central", "North Central", "North Eastern", "North Western", "Sabaragamuwa", "Southern", "Uva", "Western");
    	}else if(country=='Sweden'){
    	states=new Array();
    		states = new Array("Blekinge", "Dalarnas", "Gavleborgs", "Gotlands", "Hallands", "Jamtlands", "Jonkopings", "Kalmar", "Kronobergs", "Norrbottens", "Orebro", "Ostergotlands", "Skane", "Sodermanlands", "Stockholms", "Uppsala", "Varmlands", "Vasterbottens", "Vasternorrlands", "Vastmanlands", "Vastra Gotalands");
    	}else if(country=='Switzerland'){
    	states=new Array();
    		states = new Array("Aargau", "Appenzell Ausser-Rhoden", "Appenzell Inner-Rhoden", "Basel-Landschaft", "Basel-Stadt", "Bern", "Fribourg", "Geneve", "Glarus", "Graubunden", "Jura", "Luzern", "Neuchatel", "Nidwalden", "Obwalden", "Sankt Gallen", "Schaffhausen", "Schwyz", "Solothurn", "Thurgau", "Ticino", "Uri", "Valais", "Vaud", "Zug", "Zurich");
    	}else if(country=='Tunisia'){
    	states=new Array();
    		states = new Array("Ariana (Aryanah)", "Beja (Bajah)", "Ben Arous (Bin 'Arus)", "Bizerte (Banzart)", "Gabes (Qabis)", "Gafsa (Qafsah)", "Jendouba (Jundubah)", "Kairouan (Al Qayrawan)", "Kasserine (Al Qasrayn)", "Kebili (Qibili)", "Kef (Al Kaf)", "Mahdia (Al Mahdiyah)", "Manouba (Manubah)", "Medenine (Madanin)", "Monastir (Al Munastir)", "Nabeul (Nabul)", "Sfax (Safaqis)", "Sidi Bou Zid (Sidi Bu Zayd)", "Siliana (Silyanah)", "Sousse (Susah)", "Tataouine (Tatawin)", "Tozeur (Tawzar)", "Tunis", "Zaghouan (Zaghwan)");
    	}else if(country=='Taiwan'){
    	states=new Array();
    		states = new Array("Chang-hua", "Chia-i", "Hsin-chu", "Hua-lien", "I-lan", "Kao-hsiung", "Kin-men", "Lien-chiang", "Miao-li", "Nan-t'ou", "P'eng-hu", "P'ing-tung", "T'ai-chung", "T'ai-nan", "T'ai-pei", "T'ai-tung", "T'ao-yuan", "Yun-lin", "Chia-i", "Chi-lung", "Hsin-chu", "T'ai-chung", "T'ai-nan", "Kao-hsiung city", "T'ai-pei city");
    	}else if(country=='Thailand'){
    	states=new Array();
    		states = new Array("Amnat Charoen", "Ang Thong", "Buriram", "Chachoengsao", "Chai Nat", "Chaiyaphum", "Chanthaburi", "Chiang Mai", "Chiang Rai", "Chon Buri", "Chumphon", "Kalasin", "Kamphaeng Phet", "Kanchanaburi", "Khon Kaen", "Krabi", "Krung Thep Mahanakhon", "Lampang", "Lamphun", "Loei", "Lop Buri", "Mae Hong Son", "Maha Sarakham", "Mukdahan", "Nakhon Nayok", "Nakhon Pathom", "Nakhon Phanom", "Nakhon Ratchasima", "Nakhon Sawan", "Nakhon Si Thammarat", "Nan", "Narathiwat", "Nong Bua Lamphu", "Nong Khai", "Nonthaburi", "Pathum Thani", "Pattani", "Phangnga", "Phatthalung", "Phayao", "Phetchabun", "Phetchaburi", "Phichit", "Phitsanulok", "Phra Nakhon Si Ayutthaya", "Phrae", "Phuket", "Prachin Buri", "Prachuap Khiri Khan", "Ranong", "Ratchaburi", "Rayong", "Roi Et", "Sa Kaeo", "Sakon Nakhon", "Samut Prakan", "Samut Sakhon", "Samut Songkhram", "Sara Buri", "Satun", "Sing Buri", "Sisaket", "Songkhla", "Sukhothai", "Suphan Buri", "Surat Thani", "Surin", "Tak", "Trang", "Trat", "Ubon Ratchathani", "Udon Thani", "Uthai Thani", "Uttaradit", "Yala", "Yasothon");
    	}else if(country=='Trinidad & Tobago'){
    	states=new Array();
    		states = new Array("Couva", "Diego Martin", "Mayaro", "Penal", "Princes Town", "Sangre Grande", "San Juan", "Siparia", "Tunapuna", "Port-of-Spain", "San Fernando", "Arima", "Point Fortin", "Chaguanas", "Tobago");
    	}else if(country=='Turkey'){
    	states=new Array();
    		states = new Array("Adana", "Adiyaman", "Afyonkarahisar", "Agri", "Aksaray", "Amasya", "Ankara", "Antalya", "Ardahan", "Artvin", "Aydin", "Balikesir", "Bartin", "Batman", "Bayburt", "Bilecik", "Bingol", "Bitlis", "Bolu", "Burdur", "Bursa", "Canakkale", "Cankiri", "Corum", "Denizli", "Diyarbakir", "Duzce", "Edirne", "Elazig", "Erzincan", "Erzurum", "Eskisehir", "Gaziantep", "Giresun", "Gumushane", "Hakkari", "Hatay", "Igdir", "Isparta", "Istanbul", "Izmir", "Kahramanmaras", "Karabuk", "Karaman", "Kars", "Kastamonu", "Kayseri", "Kilis", "Kirikkale", "Kirklareli", "Kirsehir", "Kocaeli", "Konya", "Kutahya", "Malatya", "Manisa", "Mardin", "Mersin", "Mugla", "Mus", "Nevsehir", "Nigde", "Ordu", "Osmaniye", "Rize", "Sakarya", "Samsun", "Sanliurfa", "Siirt", "Sinop", "Sirnak", "Sivas", "Tekirdag", "Tokat", "Trabzon", "Tunceli", "Usak", "Van", "Yalova", "Yozgat", "Zonguldak");
    	}else if(country=='UAE'){
    	states=new Array();
    		states = new Array("Abu Dhabi", "'Ajman", "Al Fujayrah", "Sharjah", "Dubai", "Ra's al Khaymah", "Umm al Qaywayn");
    	}else if(country=='USA'){
    	states=new Array();
    		states = new Array("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");
    	}else if(country=='Uganda'){
    	states=new Array();
    		states = new Array("Adjumani", "Apac", "Arua", "Bugiri", "Bundibugyo", "Bushenyi", "Busia", "Gulu", "Hoima", "Iganga", "Jinja", "Kabale", "Kabarole", "Kaberamaido", "Kalangala", "Kampala", "Kamuli", "Kamwenge", "Kanungu", "Kapchorwa", "Kasese", "Katakwi", "Kayunga", "Kibale", "Kiboga", "Kisoro", "Kitgum", "Kotido", "Kumi", "Kyenjojo", "Lira", "Luwero", "Masaka", "Masindi", "Mayuge", "Mbale", "Mbarara", "Moroto", "Moyo", "Mpigi", "Mubende", "Mukono", "Nakapiripirit", "Nakasongola", "Nebbi", "Ntungamo", "Pader", "Pallisa", "Rakai", "Rukungiri", "Sembabule", "Sironko", "Soroti", "Tororo", "Wakiso", "Yumbe");
    	}else if(country=='Ukraine'){
    	states=new Array();
    		states = new Array("Cherkasy", "Chernihiv", "Chernivtsi", "Crimea", "Dnipropetrovs'k", "Donets'k", "Ivano-Frankivs'k", "Kharkiv", "Kherson", "Khmel'nyts'kyy", "Kirovohrad", "Kiev", "Kyyiv", "Luhans'k", "L'viv", "Mykolayiv", "Odesa", "Poltava", "Rivne", "Sevastopol'", "Sumy", "Ternopil'", "Vinnytsya", "Volyn'", "Zakarpattya", "Zaporizhzhya", "Zhytomyr");
    	}else if(country=='United Kingdom'){
    	states=new Array();
    		states = new Array("Aberdeen City", "Aberdeenshire", "Angus", "Argyll & Bute", "Bath & North East Somerset", "Bedfordshire", "Berkshire", "Blaenau Gwent", "Bridgend", "Bristol", "Buckinghamshire", "Caerphilly", "Cambridgeshire", "Cardiff", "Carmarthenshire", "Ceredidgion", "Cheshire", "ClackMannanshire", "Conwy", "Cornwall", "Cumbria", "Denbighshire", "Derbyshire", "Devon", "Dorset", "Dumfries & Galloway", "Dundee City", "Durham", "East Ayrshire", "East Dunbartonshire", "East Lothian", "East Renfrewshire", "East Riding of Yorkshire", "East Sussex", "Edinburgh", "Essex", "Falkirk", "Fife", "Flintshire", "Glasgow", "Gloucestershire", "Greater Manchester", "Gwynedd", "Hampshire", "Herefordshire", "Highlands", "Inverclyde", "Isle of Anglesey", "Kent", "Lancashire", "Leicestershire", "Lincolnshire", "London", "Merseyside", "Merthyr Tydfil", "Midlothian", "Monmouthshire", "Moray", "Neath Port Talbot", "Newport", "Norfolk", "North Ayrshire", "North Lanarkshire", "North Somerset", "North Somerset", "Northamptonshire", "Northumberland", "Nottinghamshire", "Orkney", "Oxfordshire", "Pembrokeshire", "Perth & Kinross", "Powys", "Renfrewshire", "Rhondda Cynon Taff", "Rutland", "Scottish Borders", "Shetland", "Shropshire", "Somerset", "South Lanarkshire", "South Yorkshire", "Staffordshire", "Stirling", "Suffolk", "Surrey", "Swansea", "Teesside", "Torfaen", "Tyne & Wear", "Vale of Glamorgan", "Warwickshire", "West Dunbartonshire", "West Lothian", "West Midlands", "West Sussex", "West Yorkshire", "Western Isles", "Wiltshire", "Worcestershire", "Wrexham");
    	}else if(country=='Venezuela'){
    	states=new Array();
    		states = new Array("Amazonas", "Anzoategui", "Apure", "Aragua", "Barinas", "Bolivar", "Carabobo", "Cojedes", "Delta Amacuro", "Dependencias Federales", "Distrito Federal", "Falcon", "Guarico", "Lara", "Merida", "Miranda", "Monagas", "Nueva Esparta", "Portuguesa", "Sucre", "Tachira", "Trujillo", "Vargas", "Yaracuy", "Zulia");
    	}else if(country=='Vietnam'){
    	states=new Array();
    		states = new Array("An Giang", "Bac Giang", "Bac Kan", "Bac Lieu", "Bac Ninh", "Ba Ria-Vung Tau", "Ben Tre", "Binh Dinh", "Binh Duong", "Binh Phuoc", "Binh Thuan", "Ca Mau", "Cao Bang", "Dac Lak", "Dac Nong", "Dien Bien", "Dong Nai", "Dong Thap", "Gia Lai", "Ha Giang", "Hai Duong", "Ha Nam", "Ha Tay", "Ha Tinh", "Hau Giang", "Hoa Binh", "Hung Yen", "Khanh Hoa", "Kien Giang", "Kon Tum", "Lai Chau", "Lam Dong", "Lang Son", "Lao Cai", "Long An", "Nam Dinh", "Nghe An", "Ninh Binh", "Ninh Thuan", "Phu Tho", "Phu Yen", "Quang Binh", "Quang Nam", "Quang Ngai", "Quang Ninh", "Quang Tri", "Soc Trang", "Son La", "Tay Ninh", "Thai Binh", "Thai Nguyen", "Thanh Hoa", "Thua Thien-Hue", "Tien Giang", "Tra Vinh", "Tuyen Quang", "Vinh Long", "Vinh Phuc", "Yen Bai", "Can Tho", "Da Nang", "Hai Phong", "Hanoi", "Ho Chi Minh");
    	}
    	
    	var opt = document.getElementById('state').options;
				
		opt[0] = new Option('select state','');
		for(var count = 0 ; count < states.length ; count++){
			opt[count+1] = new Option(states[count], states[count]);
		}
    	
    }
    </script>
    
    <script>
                 setTimeout(country,1000);
                 function country()
                 {
               		 for(var i=0;i<document.getElementsByName("country")[0].length;i++)
               		 {
               		 	if('${command.country}'==document.getElementsByName("country")[0].options[i].value)
               		 	{
               		 		document.getElementsByName("country")[0].options[i].selected=true;
               		 		getStates(document.getElementsByName("country")[0].options[i].value);
               		 		setTimeout(select,100);
               		 	}
               		 }
                 }
                 
                  function select()
                 {
               		 for(var i=0;i<document.getElementsByName("state")[0].length;i++)
               		 {
               		 	if('${command.state}'==document.getElementsByName("state")[0].options[i].value)
               		 	{
               		 		document.getElementsByName("state")[0].options[i].selected=true;
               		 	}
               		 }
                 }
               
                
                </script>
 <script type="text/javascript">

 function languages()
 {
	   var c='${command.country}';
	  // alert('cunt-dd--ff--'+c);
	   var s='${command.state}';
	  // alert('st-id-kk---ch'+s);
	   document.getElementById("country").value='${command.country}';	
	   document.getElementById("state").value=s;	
	   
 
 </script>
 <script>
   function displayBank()
  {
	 var loan="Business Loan";

	 var bank=document.getElementById("bankdisplay").value;
	
	  
	$.ajax({
	   	 
	    url: 'displaybank.html',   
	   	data:"loans="+loan+"&banks="+bank,
	   
	    success: function(response){
	   			
	      		var k=response.split(",");
	   			for(var i=0;i<k.length-1;i++)
	   			 {
		 			var l=document.getElementById("bankdisplay");
	   				var option=document.createElement("option");
	   				option.text=k[i];
	   				l.add(option);
				 }
	   		
	    },
	    error: function(e){
	   		 alert('Error: ' + e);
	    }
	    });
} 
  
  </script>
  
   <script>
   function displayInterest()
  {
	 var loan="Business Loan";

	 var bank=document.getElementById("bankdisplay").value;
	
	  
	$.ajax({
	   	 
	    url: 'displayinterest.html',   
	   	data:"loans="+loan+"&banks="+bank,
	   
	    success: function(response){
	   			
	      
	   			alert(response);
	   			
	   		    document.getElementById("interestrate").value = response;
	   			
				 
	   		
	    },
	    error: function(e){
	   		 alert('Error: ' + e);
	    }
	    });
} 
  
  </script> 
  <script>
  function displayEmps()
  {
	  var status=document.getElementById("status").value;
	  
	  if(status=="Verification"){

	$.ajax({
	   	 
	    url: 'bankemps.html',   
	  	success: function(response){
	   
	      		var k=response.split(",");
	   			for(var i=0;i<k.length-1;i++)
	   			 {
		 			var l=document.getElementById("emps");
	   				var option=document.createElement("option");
	   				option.text=k[i];
	   				l.add(option);
				 }
	   		
	    },
	    error: function(e){
	   		 alert('Error: ' + e);
	    }
	    });
	  }
} 
  
  </script>
  <style>
body {  
   
}  
.error{
     color:red;font-weight: bold;
}
</style>
</head>
<body onload="country();">

<sec:authorize ifAllGranted="ROLE_ADMIN">
<form:form method="POST" action="aabloanresponse.html">
     <center>
    
     <h2>Business Loan</h2>
    
     <table border="0" align="center">
 <tr><td><h4>BASIC DETAILS</h4></td></tr>
	<tr>
		<td><form:label path="id">Id</form:label></td>
		<td><form:input path="id"  readonly="true"/></td><td>
	  </tr>
	   <tr>
			<td>User Id</td>
			<td><form:input path="regid" readonly="true"/></td>
		</tr>  
	<tr>
		<td>First name</td>
		
		<td><form:input path="firstname"  readonly="true"/></td>
		<td><form:errors path="firstname" cssClass="error"></form:errors></td>
    </tr>
	<tr>
		<td>Middle name</td>
	
		<td><form:input path="middlename"  readonly="true"/></td>
		<td><form:errors path="middlename" cssClass="error"></form:errors></td>
	</tr>
	<tr>
		<td>Last name</td>
		
		<td><form:input path="lastname"  readonly="true"/></td>
		<td><form:errors path="lastname" cssClass="error"></form:errors></td>
	</tr>
	
	<tr>
		<td>Email id</td>
		
		<td><form:input path="email"  readonly="true"/></td>
		<td><form:errors path="email" cssClass="error"></form:errors></td>
	</tr>
		<tr>
			<td>Mobile No</td>
		
			<td><form:input path="mobile"  readonly="true"/></td>
			<td><form:errors path="mobile" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Gender</td>
		
			<td><form:radiobutton path="gender"  readonly="true" value="male"/>Male
				<form:radiobutton path="gender" value="female"/>Female
				
			</td>
			<td><form:errors path="gender" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Date of birth</td>
		
			<td><form:input path="dateofbirth"  readonly="true" class="easyui-datebox"  style="width:100%;"></form:input></td>
			<td ><form:errors path="dateofbirth" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Marrital Status</td>
		
			<td><form:radiobutton path="maritalstatus"  readonly="true" value="sinle"/>Single
				<form:radiobutton path="maritalstatus" value="married"/>Married
				
			</td>
			<td><form:errors path="maritalstatus" cssClass="error"></form:errors></td>
		</tr>
		<tr>
		<td>Father/Spouse name</td>
	
		<td><form:input path="fsname"  readonly="true"/></td>
		<td><form:errors path="fsname" cssClass="error"></form:errors></td>
	</tr>
		<tr>
		<td>Pan No</td>
	
		<td><form:input path="pan"  readonly="true"/></td>
		<td><form:errors path="pan" cssClass="error"></form:errors></td>
	</tr>
	<tr>
		<td>Aadhaar No</td>
	
		<td><form:input path="aadhaarno"  readonly="true"/></td>
		<td><form:errors path="aadhaarno" cssClass="error"></form:errors></td>
	</tr>
	<tr>
		<td>Passport No</td>
	
		<td><form:input path="passportno"  readonly="true"/></td>
		<td><form:errors path="passportno" cssClass="error"></form:errors></td>
	</tr>
	<tr>
		<td>Education Qualification</td>
	
		<td><form:input path="educationqualification"  readonly="true"/></td>
		<td><form:errors path="educationqualification" cssClass="error"></form:errors></td>
	</tr>

<tr><td><h4>CURRENT ADDRESS DETAILS</h4></td></tr>



 	
 		<tr><td>Address</td>
<td><form:textarea path="address"  readonly="true" style="width:166px"></form:textarea></td>
<td ><form:errors path="address" cssClass="error"></form:errors></td></tr>
     <tr><td>Country</td>
  
		<td><form:select path="country" id="country"  readonly="true" cssStyle="textbx;width:173px"  onchange="getStates(this.value);">
								 
								  <option value="">select country</option>
								  <option value= 'Argentina'>Argentina</option>
								  <option value= 'Australia'>Australia</option> 
								  <option value= 'Austria'>Austria</option> 
								  <option value= 'Azerbaijan'>Azerbaijan</option> 
								  <option value= 'Belgium'>Belgium</option>
								  <option value= 'Brazil'>Brazil</option> 
								  <option value= 'Burma'>Burma</option>
								  <option value= 'Cameroon'>Cameroon</option> 
								  <option value= 'Canada'>Canada</option> 
								  <option value= 'Chile'>Chile</option> 
								  <option value= 'China'>China</option>
								  <option value= 'Colombia'>Colombia</option> 
								  <option value= 'Costa Rica'>Costa Rica</option> 
								  <option value= 'Czech Republic'>Czech Republic</option> 
								  <option value= 'Denmark'>Denmark</option> 
								  <option value= 'Dominican Republic'>Dominican Republic</option> 
								  <option value= 'Egypt'>Egypt</option> 
								  <option value= 'ELSALEl Salvador'>El Salvador</option> 
					              <option value= 'Finland'>Finland</option> 
					              <option value= 'France'>France</option> 
					              <option value= 'Germany'>Germany</option> 
					              <option value= 'Greenland'>Greenland</option> 
					              <option value= 'Honduras'>Honduras</option> 
					              <option value= 'Hungary'>Hungary</option> 
					              <option value= 'India'>India</option>  
					              <option value= 'Indonesia'>Indonesia</option> 
					              <option value= 'IreLand'>IreLand</option> 
					              <option value= 'Israel'>Israel</option> 
					              <option value= 'Italy'>Italy</option> 
					              <option value= 'Japan'>Japan</option>  
					              <option value= 'Kazakhstan'>Kazakhstan</option> 
					              <option value= 'Kenya'>Kenya</option> 
					              <option value= 'Kuwait'>Kuwait</option> 
					              <option value= 'Luxemburg'>Luxemburg</option> 
					              <option value= 'Malaysia'>Malaysia</option> 
					              <option value= 'Mexico'>Mexico</option> 
					              <option value= 'Morocco'>Morocco</option> 
	              				  <option value= 'Madagascar'>Madagascar</option>
					              <option value= 'Netherlands'>Netherlands</option> 
					              <option value= 'New Zealand'>New Zealand</option> 
					              <option value= 'Nigeria'>Nigeria</option> 
					              <option value= 'Norway'>Norway</option> 
					              <option value= 'Pakistan'>Pakistan</option> 
					              <option value= 'Panama'>Panama</option> 
					              <option value= 'Peru'>Peru</option> 
					              <option value= 'Philippines'>Philippines</option> 
					              <option value= 'Poland'>Poland</option> 
					              <option value= 'Portugal'>Portugal</option> 
					              <option value= 'Romania'>Romania</option> 
					              <option value= 'Russia'>Russia</option> 
					              <option value= 'Saudi Arabia'>Saudi Arabia</option> 
					              <option value= 'South Africa'>South Africa</option> 
					              <option value= 'Spain'>Spain</option> 
					              <option value= 'Sri Lanka'>Sri Lanka</option> 
					              <option value= 'Sweden'>Sweden</option> 
					              <option value= 'Switzerland'>Switzerland</option> 
					              <option value= 'Tunisia'>Tunisia</option> 
					              <option value= 'Taiwan'>Taiwan</option> 
					              <option value= 'Thailand'>Thailand</option> 
					              <option value= 'Trinidad & Tobago'>Trinidad & Tobago</option> 
					              <option value= 'Turkey'>Turkey</option> 
					              <option value= 'UAE'>UAE</option> 
					              <option value= 'USA'>USA</option> 
					              <option value= 'Uganda'>Uganda</option> 
					              <option value= 'UKNUkraine'>Ukraine</option> 
					              <option value= 'United Kingdom'>United Kingdom</option> 
					              <option value= 'Venezuela'>Venezuela</option> 
					              <option value= 'Vietnam'>Vietnam</option>
	</form:select><br> 
 	</td>
     <td><form:errors path="country" cssClass="error" /></td>
     </tr>
     <tr>  
      		<td>State</td> 
      	
      		<td><form:select path="state" id="state"  readonly="true"  cssStyle="textbx;width:173px" cssClass="textbx">
					<option value="">select state</option>
				</form:select></td>
			<td><form:errors path="state" cssClass="error" /></td>
     </tr> 
	 <tr>
	 	<td>City</td>
	
		<td><form:input path="city"  readonly="true"/></td>
		<td ><form:errors path="city" cssClass="error"></form:errors></td>
	</tr>
	<tr>
		<td>Pin code</td>
		
		<td><form:input path="pincode"  readonly="true"/></td>
		<td ><form:errors path="pincode" cssClass="error"></form:errors></td>
	</tr>
	
<tr><td><h4>DETAILS OF COMPANY</h4></td></tr>

	<tr>
			<td>Legal Status</td>
		
			<td><form:radiobutton path="legalstatus"  readonly="true" value="Pvtltd"/>Pvt.Ltd
				<form:radiobutton path="legalstatus" value="Publicltd"/>Public Ltd
			</td>
			<td><form:errors path="legalstatus" cssClass="error"></form:errors></td>
		</tr>
	<tr>
		<td>Year of Incorporation</td>
		<td><form:input path="yearofincorp"  readonly="true"/></td>
		<td><form:errors path="yearofincorp" cssClass="error"></form:errors></td>
	</tr>
	<tr>
		<td>Registration No</td>
		<td><form:input path="rocregno"  readonly="true"/></td>
		<td><form:errors path="rocregno" cssClass="error"></form:errors></td>
	</tr>
	<tr>
			<td>Ownership</td>
		
			<td><form:radiobutton path="ownership"  readonly="true" value="Owned"/>Owned
				<form:radiobutton path="ownership" value="Rented"/>Rented
			</td>
			<td><form:errors path="ownership" cssClass="error"></form:errors></td>
		</tr>
	<tr>
		<td>Landline No</td>
		<td><form:input path="landline"  readonly="true"/></td>
		<td><form:errors path="landline" cssClass="error"></form:errors></td>
	</tr>
	
	<tr>
		<td>No. of Branch</td>
		<td><form:input path="noofbranches"  readonly="true"/></td>
		<td><form:errors path="noofbranches" cssClass="error"></form:errors></td>
	</tr>
	<tr>
		<td>Name of Cities</td>
		<td><form:input path="nameofcities"  readonly="true"/></td>
		<td><form:errors path="nameofcities" cssClass="error"></form:errors></td>
	</tr>
	<tr>
		<td>Name of Employess</td>
		<td><form:input path="noofemployees"  readonly="true"/></td>
		<td><form:errors path="noofemployees" cssClass="error"></form:errors></td>
	</tr>
		<tr>
		<td>Fax</td>
		<td><form:input path="fax"  readonly="true"/></td>
		<td><form:errors path="fax" cssClass="error"></form:errors></td>
	</tr>
	<tr>
			<td>Tax Paid</td>
		
			<td><form:radiobutton path="taxpaid"  readonly="true" value="Yes"/>Yes
				<form:radiobutton path="taxpaid" value="No"/>No
			</td>
			<td><form:errors path="taxpaid" cssClass="error"></form:errors></td>
		</tr>
	
	
 		<tr><td>Address</td>
<td><form:textarea path="regofcaddress" readonly="true" style="width:166px"></form:textarea></td>
<td ><form:errors path="regofcaddress" cssClass="error"></form:errors></td></tr>

<tr><td><h4>INCOME DETAILS</h4></td></tr>

	<tr>
		<td>Income (per year)</td>
		<td><form:input path="income" readonly="true"/></td>
		<td><form:errors path="income" cssClass="error"></form:errors></td>
	</tr>

<tr><td><h4>LOAN DETAILS</h4></td></tr>

	<tr>
		<td>Loan Type</td>
		<td><form:input path="loantype" readonly="true"/></td>
		<td><form:errors path="loantype" cssClass="error"></form:errors></td>
	</tr>
	<tr>
		<td>Required Amount</td>
		<td><form:input path="loanamount" readonly="true"/></td>
		<td><form:errors path="loanamount" cssClass="error"></form:errors></td>
	</tr>
	<tr>
		<td>Tenture Required</td>
		<td><form:input path="tenture" readonly="true"/></td>
		<td><form:errors path="tenture" cssClass="error"></form:errors></td>
	</tr>
	<tr>
		<td>Bank Type</td>
			<td><form:input path="banktype" readonly="true"/></td>
		<td><form:errors path="banktype" cssClass="error"></form:errors></td>
	</tr>
	
	<tr>
		<td>Interest Rate</td>
		<td><form:input path="interestrate" id="interestrate" readonly="true"/></td>
		<td><form:errors path="interestrate" cssClass="error"></form:errors></td>
	</tr>

<tr>
			<td>Status Type</td>
			<td><form:select path="status" style="width:173px" id="status">
				<option value="">Select Option</option>
				<option value="Sanction">Sanction</option>
				<option value="Rejected">Reject</option>
				
			</form:select>
			</td>
		<td><form:errors path="status" cssClass="error"></form:errors></td>
		</tr>
<tr>
			
			<td><form:hidden path="assignedto"></form:hidden>
			</td>
		</tr>
		<tr>
			<td><form:hidden path="loanapplydate"/>
		</tr>
		<tr>
			<td></td>
			<td colspan="2"><input type="submit" value="Apply"/>
			<input type="reset" value="Reset"/></td>
		</tr>
</table>
    
			</center>
       </form:form>
       </sec:authorize>
</body>
<br>



</html>