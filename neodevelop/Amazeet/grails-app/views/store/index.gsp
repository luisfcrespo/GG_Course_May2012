<!doctype html>
<html>
  <head>
    <title>Store</title>
    <meta name="layout" content="earthlingtwo" />
    <r:require modules="jquery"/>
    <r:script>
      function startLoader(){
        $('img#loader').fadeIn(1000);
      }
      function stopLoader(){
        $('img#loader').fadeOut(1000); 
      }
      function successEvent(data){
        //alert(data);
        $('#messageStatusOk').slideDown('slow').delay(2000).fadeOut();
      }
    </r:script>
  </head>
  <body>
    <br/>
    <g:link action="checkout">CHECKOUT</g:link>
    <br/>
    <r:img uri="/images/spinner.gif" id="loader" style="display:none;"/>
    <div id="messageStatusOk" style="display:none;">
      ${message(code:'item.added',default:'El item se ha añadido')}
    </div>
    <br/>
    
    <h2>Productos</h2>

    <table>
      <thead>
        <tr>
          <td><b>${message(code:'product.name.label',default:'Name')}</b></td>
          <td><b>${message(code:'product.price.label',default:'Price')}</b></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </thead>
      <tbody>
        <g:each in="${products}" var="p">
          <tr>
            <td>${p.name}</td>
            <td>$ ${p.price}</td>
            <td> 
              <store:showProduct url="${p.urlImage}" size="small"/> 
            </td>
            <td>
              <g:formRemote url="[action:'addItemAsync']" name="addItemAsync" update="itemsInCart" onLoading="startLoader()" onComplete="stopLoader()" onSuccess="successEvent(data)">
                <g:hiddenField name="productId" value="${p.id}"/>
                <g:select name="quantity" from="${1..9}" />
                <g:submitButton name="submit" value="Agregar" />
              </g:formRemote>
            </td>
          </tr>
        </g:each>
      </tbody>
    </table>

    
  </body>
</html>