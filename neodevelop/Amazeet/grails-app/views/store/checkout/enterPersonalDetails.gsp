<!doctype html>
<html>
  <head>
    <title>Store</title>
    <meta name="layout" content="earthlingtwo" />
  </head>
  <body>
    
    <h2>Tus datos:</h2>

    <h3>Articulos a comprar</h3> 
    <h4>${totalItems}</h4>
    <h3>Total a pagar:</h3>
    <h4><g:formatNumber number="${totalPrice}" type="currency" locale="MX" currencySymbol="\$" /></h4>
    
    <br/>
    <g:link event="continueShopping">Continuar comprando</g:link>
    <br/>
    <g:link event="showCart">Revisar la orden</g:link>
    <br/>
    <g:link event="confirmOrder">Generar la orden de pago</g:link>
  </body>
</html>