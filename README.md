Connect two services using RestTemplate

Go to main File

@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

 use restemplate Obj

 resTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id"+id,List.class) //Return all the uses/citizens from citizen service those who r enrolled for a specific vaccination center
