// add pageTitle

// add groceries

var pageTitle = 'My Shopping List';
let groceries = ['Chocolate Milk', 'Steak', 'Apple Juice', 'Frozen Pizza', 'Sunchips', 'Half & Half', 'Cherry Coke', 'Popcorn', 'Bacon', 'Eggs'];
const shopList = document.getElementById('groceries');


/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  document.querySelector('#title').innerText = pageTitle;

}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
 function displayGroceries() {
  const shoppingList = document.getElementById('groceries')
  groceries.forEach((anItem) => {
    const newItem = document.createElement('li')
    addItem(newItem, anItem.item)
    shoppingList.insertAdjacentElement('beforeend', newItem)
  });
}
function addItem(parent) {
  const aGrocery = document.createElement('p');
  groceries.forEach((anItem) => {
    aGrocery.innerText += " " + anItem;
  });
  parent.appendChild(aGrocery)
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
 function markCompleted() {
  const list = document.getElementById('groceries')
  const items = Array.from(list.children)
  items.forEach((item) => {
    item.setAttribute('class', 'completed')
  });
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
