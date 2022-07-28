# Vue Event Handling Lecture Notes

The focus of today's lecture is to add on to the Product Review component. You'll add new functionality to the component like the ability to add new reviews and to filter the reviews by their star rating.

## Getting started

First, take a moment to run the Vue component and recap its functionality. Have the students follow along with running `npm install` and `npm run serve`.

Go through the code and briefly review what was written in the previous lecture, in particular the fields of the `review` objects in the `reviews` array.

Point out the only thing that has been added is `newReview: {}` in the `data` section which is used for capturing the data for the new review form.

> Optional: the `averageRating()` computed property has been slightly refactored to round the average rating to two decimal points. If it didn't round, the average rating could overflow its container. It's up to you if you want to point this out to the students too:

```js
averageRating() {
    let sum = this.reviews.reduce((currentSum, review) => {
       return currentSum + review.rating;
    }, 0);
    return (sum / this.reviews.length).toFixed(2);
}
```

## Add new review

Next, you'll create the form to add a new review. This is a good opportunity to reinforce creating HTML forms.

After the `div`s displaying the number of reviews, start a new `<form>` tag. Have the students help you determine the form inputs (`input`, `select`, `textarea`) and see if you can get a student to suggest `<label>` to identify the fields to the user.

As you add each form `input`, add the appropriate `v-model` binding. Make sure to use the `.number` modifier for `rating` since you want that saved as a number:

```html
<form>
    <div class="form-element">
        <label for="reviewer">Name:</label>
        <input id="reviewer" type="text" v-model="newReview.reviewer" />
    </div>
    <div class="form-element">
        <label for="title">Title:</label>
        <input id="title" type="text" v-model="newReview.title" />
    </div>
    <div class="form-element">
        <label for="rating">Rating:</label>
        <select id="rating" v-model.number="newReview.rating">
            <option value="1">1 Star</option>
            <option value="2">2 Stars</option>
            <option value="3">3 Stars</option>
            <option value="4">4 Stars</option>
            <option value="5">5 Stars</option>
        </select>
    </div>
    <div class="form-element">
        <label for="review">Review:</label>
        <textarea id="review" v-model="newReview.review"></textarea>
    </div>
    <input type="submit" value="Save">
    <input type="button" value="Cancel">
</form>
```

>Note: the CSS for class `form-element` has already been provided. It'll help make the form look nicer.

Now, you need a way to actually save the data. Go to the `<script>` section, after the `computed` section, add the `methods` section:

```js
computed: {
    // properties omitted for brevity
},
methods: {

}
```
>Note: make sure to add a comma after the closing bracket for `computed`.

In the `methods` section, add a new method called `addNewReview()`. See if you can get the students to suggest `unshift` as the way to add an element to the beginning of an array, and what should be passed to that method:

```js
methods: {
    addNewReview() {
        this.reviews.unshift(this.newReview);
    }
}
```

The last thing you need to do is go back to the form and add the event handler. Remind the students that `.prevent` prevents the browser from attempting to send a request and refreshing the page:

```html
<form v-on:submit.prevent="addNewReview">
```

Return to the browser and show the students. The form saves the new review, but the fields are still filled out. That's not a great user experience because a user typically expects the form to clear once the form is successfully submitted.

Go back to the `methods` section. You could add some code to the `addNewReview()` method you added, but that might duplicate the behavior the user expects from the "Cancel" button in the form.

Create a new method called `resetForm()`. Because the form uses two-way data binding (`v-model`), all you need to do is set `newReview` to an empty object:

```js
resetForm() {
    this.newReview = {};
}
```

Then call the `resetForm()` method from `addNewReview()`:

```js
methods: {
    addNewReview() {
        this.reviews.unshift(this.newReview);
        this.resetForm();
    },
    resetForm() {
        this.newReview = {};
    }
}
```

Back in the browser, fill out the form again and click the "Save" button. The form now clears after submitting.

Now, how do you hook up the `resetForm()` method to the "Cancel" button? See if the students can suggest anything.

You're looking for adding the click event handler to the "Cancel" button:

```html
<input type="button" value="Cancel" v-on:click.prevent="resetForm">
```

Back in the browser again, fill out the form, but hit the "Cancel" button instead. The form clears and the data is not saved.

## Hide the form

Next, you're going to hide the form by default and create a link to show the form. The form hides again after clicking the "Save" or "Cancel" buttons.

Add a new property in `data` called `showForm` and set to `false`:

```js
data() {
    return {
        // omitted for brevity
        newReview: {},
        showForm: false,
```

Above the form, add a new link on the page that says `Show Form`:

```html
<a href="#">Show Form</a>
```

Tell the students you want to be able to set `showForm` to `true` when clicking "Show Form" and have the form only appear when `showForm === true`. Ask them how this can be accomplished?

Two things need to be done:

* Add a click event handler to the "Show Form" link that sets `showForm = true`.
* Add a `v-if` attribute to the form with the value `showForm === true`.

```html
<a href="#" v-on:click.prevent="showForm = true">Show Form</a>

<form v-on:submit.prevent="addNewReview" v-if="showForm === true">
```

Next, go back to the `resetForm()` method, and set `showForm` to `false`:

```js
resetForm() {
    this.newReview = {};
    this.showForm = false;
}
```

Show the page again. The form is hidden and "Show Form" is displayed. Click "Show Form", fill it out, and press the "Save" button. The form is submitted and disappears again.

Lastly, it would be nice if the "Show Form" link disappeared while the form was displayed. Just as a `v-if` was used to show the form, the opposite logic can be used to hide the link.

Add `v-if="showForm === false"` (or `v-if="!showForm"` if you prefer) to the "Show Form" link:

```html
<a href="#" v-on:click.prevent="showForm = true" v-if="showForm === false">Show Form</a>
```

## Review filtering

Now, it's time to add another piece to this application. You need to ensure that if the user clicks on the counts of the star ratings, the reviews filter to only show those reviews. For example, if a user clicks on the number of one-star reviews, they should only see one-star reviews.

How would you do this? Right now, you can see all the reviews in the display. If you only want to show some of the reviews, you'll need another property to show that list of reviews instead of all of them. If you know what star reviews you want to show, show them. Otherwise, show them all.

First, create a new data variable that holds the filter for the reviews:

``` JavaScript
data() {
    return {
        // omitted for brevity
        newReview: {},
        showForm: false,
        filter: 0,
        ...
```

If the filter is set to 0, you'll see all the reviews. If the filter is set to any other number, you'll only see the reviews for that rating.

Next, create a new `computed` property to return these filtered reviews:

``` JavaScript
filteredReviews() {
    return this.reviews.filter(review => {
        return this.filter === 0 ? true : this.filter === review.rating;
    });
}
```

You can now use this new property in the `v-for` for the `div`:

``` HTML
<div class="review" v-for="review in filteredReviews" v-bind:key="review.id">
```

You should see no difference in the view now. Because the filter is set to 0 by default, it shows all the reviews. Now you can set up the text in the rating display to set the filter to the star rating you want. To do this, use a `v-on` on a click:

``` HTML
<div class="well">
    <span class="amount" v-on:click="filter = 1">{{ numberOfOneStarReviews }}</span>
    1 Star Review{{ numberOfOneStarReviews === 1 ? '' : 's' }}
</div>
```

You can do this for all the filters. When you click on a number, you'll only see the reviews with that number of stars. When you add a new review, the review is automatically shown in either view.

If you want, you can also set the average review number to show all the reviews again. To do this, set the filter back to 0:

``` HTML
<div class="well">
    <span class="amount" v-on:click="filter = 0">{{ averageRating }}</span>
    Average Rating
</div>
```

> Students may ask when do you use a method versus putting the code in the `v-on`.
>
> `methods` are useful when you have code that you want to execute on an event. However, you can also put code directly in the `v-on`. Why use one over the other?
>
> Putting code in the `v-on` is useful if you're only setting a variable. During Vue development, this makes sense.
>
> You should use `methods` if you need to write more than one line of code or code used in multiple `v-on` bindings. `methods` help to consolidate code in one place and prevent code duplication, which makes maintenance easier.

## Refactoring opportunity

If you still have time, you can walk the students through a refactoring opportunity. The computed properties that display the number of star ratings—like `numberOfOneStarReviews()`, `numberOfTwoStarReviews()`—have duplicated logic and can be refactored.

Create a new method named `numberOfReviews` that takes a parameter `numOfStars`. The logic is similar to what's in the computed properties, except you compare `review.rating` to the `numOfStars` parameter:

```js
methods: {
    addNewReview() {
        //...
    },
    resetForm() {
        //...
    },
    numberOfReviews(numOfStars) {
        return this.reviews.reduce((currentCount, review) => {
            return currentCount + (review.rating === numOfStars);
        }, 0);
    }
}
```

Now, the computed properties can call the `numberOfReviews()` method:

```js
computed: {
    //...
    numberOfOneStarReviews() {
      return this.numberOfReviews(1);
    },
    numberOfTwoStarReviews() {
      return this.numberOfReviews(2);
    },
    numberOfThreeStarReviews() {
      return this.numberOfReviews(3);
    },
    numberOfFourStarReviews() {
      return this.numberOfReviews(4);
    },
    numberOfFiveStarReviews() {
      return this.numberOfReviews(5);
    }
```

