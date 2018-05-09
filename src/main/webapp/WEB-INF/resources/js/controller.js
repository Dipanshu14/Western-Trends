var cartApp = angular.module ('', []);

cartApp.controller('cartCtrl', function($scope, $http){

    $scope.refreshCart = function(){
       $http.put('http://localhost:8080/WesternTrends/rest/cart/' + $scope.cartId).success(function (data){
           $scope.cart = data;
       });
    };

    $scope.clearCart = function(){
        $http.delete('http://localhost:8080/WesternTrends/rest/cart/' + $scope.cartId).success($scope.refreshCart());
    };

    $scope.initCartId = function(cartId){
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function(id){
    	
        $http.post('http://localhost:8080/WesternTrends/rest/cart/add/'+id).success(function (){
            alert('Product successfully added to the cart!');
        });
    };

    $scope.removeFromCart = function(id){
        $http.put('http://localhost:8080/WesternTrends/rest/cart/remove/' +id).success(function(data){
           $scope.refreshCart();
        });
    };

    $scope.calGrandTotal = function(){
        var grandTotal = 0;

        for (var i = 0; i < $scope.cart.cartItems.length; i++){
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
    }
});