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
		"/rest/$id?"(controller:'productRest',parseRequest:true){
			action = [GET:'show',POST:'save',DELETE:'delete']
		}
		"500"(view:'/error')
	}
}
