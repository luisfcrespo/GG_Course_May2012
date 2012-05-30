class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
		//"/mipropiaUrl"(controller:"product",action:"accion")

		//"/"(view:"/index")
		"/"(controller:"store",action:'index')
		"/checkoutMyCart"(controller:"store",action:"checkout")
		"500"(view:'/error')
	}
}
