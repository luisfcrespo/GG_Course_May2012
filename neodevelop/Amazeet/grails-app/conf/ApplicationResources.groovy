modules = {
    application {
        resource url:'js/application.js'
    }

    earthlingtwo {
      dependsOn 'css'
    }

    imagesForTheme {
      (1..9).each{ n ->
        resource url:"earthlingtwo/images/img0${n}.jpg"
      }
      
      resource url:"earthlingtwo/images/img10.gif"
      resource url:"earthlingtwo/images/img11.gif"

      resource url:"earthlingtwo/images/img12.jpg"
      resource url:"earthlingtwo/images/img15.jpg"

    }

    images {
      resource url:"images/spinner.gif"
    }

    css {
      resource url:"earthlingtwo/style.css"      
    }
}