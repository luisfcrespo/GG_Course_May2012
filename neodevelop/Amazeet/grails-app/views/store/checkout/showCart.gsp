<!doctype html>
<html>
  <head>
    <title>Store</title>
    <meta name="layout" content="earthlingtwo" />
  </head>
  <body>
    
    <h2>Tu carrito:</h2>

    <table border="1px" cellpadding="5" cellspacing="5">
      <thead>
        <tr>
          <td><b>${message(code:'product.name.label',default:'Name')}</b></td>
          <td><b>${message(code:'product.price.label',default:'Price')}</b></td>
          <td><b>${message(code:'product.quantity.label',default:'Quantity')}</b></td>
          
        </tr>
      </thead>
      <tbody>
        <g:each in="${session.shoppingCart.items}" var="item">
          <tr>
            <td>${item.product.name}</td>
            <td><g:formatNumber number="${item.product.price}" type="currency" locale="MX" currencySymbol="\$" /></td>
            <td>${item.quantity}</td>
          </tr>
        </g:each>
      </tbody>
      <tfoot>
        <tr>
          <td>Totales</td>
          <td><g:formatNumber number="${totalPrice}" type="currency" locale="MX" currencySymbol="\$" /></td>
          <td>${totalItems}</td>
        </tr>
      </tfoot>
    </table>
    <br/>
    <g:link event="continueShopping">Continuar comprando</g:link>
    <br/>
    <g:link event="cancelOrder">Cancelar la orden</g:link>
    <br/>
    <g:link event="checkoutThis">Confirmar orden</g:link>
  </body>
</html>