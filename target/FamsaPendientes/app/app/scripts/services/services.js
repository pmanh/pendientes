/**
 * @author Pedro Manuel Hernandez
 * @since 2017-01-31 
 */
angular.module('FamsaPendings')
.factory('Type', function ($resource) {
    return $resource('service/type/:id',{id:'@id'},  {
        update: {method:'PUT'},
        drop: {method: 'DELETE'}
      });
})
.factory('Pending', function ($resource) {
    return $resource('service/pending/:id',{id:'@id'},  {
        update: {method:'PUT'},
        drop: {method: 'DELETE'}
      });
});
