var items=[];
function AddToCard(id){
    var item = {
        product_id:id ,
        number:1
    };
    items=pushItem(item,items);
    document.getElementById('itemNumber').textContent=items.length;
    document.getElementById('items').value=JSON.stringify(items);
}
function pushItem(item, array) {
    var found=array.some(e=>e.product_id===item.product_id);
    if (!found) {
        array.push(item);
        item.number = 1;
    } else {
        var update=array.find(i=>i.product_id===item.product_id);
        update.number++;
    }
    return array;
}