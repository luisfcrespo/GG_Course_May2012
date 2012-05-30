<!doctype html>
<html>
  <head>
    <title>Store</title>
    <meta name="layout" content="earthlingtwo" />
  </head>
  <body>
    
    <h2>Tu orden:</h2>

    <h3>Articulos a comprar</h3> 
    <h4>${totalItems}</h4>
    <h3>Total a pagar:</h3>
    <h4><g:formatNumber number="${totalPrice}" type="currency" locale="MX" currencySymbol="\$" /></h4>
    
    <h2>Tu pago generado:</h2>
    ${payment?.transactionId}
    <br/>
    ${payment?.id}

    <g:link controller="store">Volver a comprar</g:link>
  </body>
</html>