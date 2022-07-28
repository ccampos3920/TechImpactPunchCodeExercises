# Vue Router Lecture Code Walkthrough

In today's class, you'll use the product review application from a previous lecture. The starting code has Vue Router installed, and all of the default routes have been removed. There's some initial seed data for products and reviews in `/src/store/index.js`, and the components have been modified to work with this data.

## Existing application

The topics you should cover are:

- `/src/router/index.js`: Vue Router Configuration
- `/src/store/index.js`: Vuex Store
- `/src/views/`: Vue Router has added this directory
- `/src/main.js`: Changes made here to import Vue Router
- `/src/components/ProductsList.vue`: A component to display a list of products from the store
- `/src/App.vue`: Does nothing currently

If you want, you can run the application to show that there are no errors and no output. This is because `App.vue` isn't doing anything right now, but you'll fix that later.

## Products list

There is a new `ProductsList` component in `/src/components` that's responsible for retrieving a list of products from the store, iterating over them, and displaying each product. Your first task is to create a new view in the `/views` folder called `Products.vue`:

```html
<template>
  <div class="products">
    <h1>Products</h1>
    <products-list />
  </div>
</template>

<script>
  import ProductsList from '@/components/ProductsList';

  export default {
    components: {
      ProductsList
    }
  };
</script>
```

### View versus components

This is a great time to talk about the difference between the `/components` and `/views` folder. Each folder contains Vue components and semantically, they're similar. What separates a view from a component is that any component defined in the `/views` folder has a route associated with it and is used for organizing logic components. Components that you create in the `/components` folder are logic components meant to hold business logic, serve a single purpose, and are often reusable.

You can also think of `/views` as "pages" in your Single Page Application that you can navigate to. Each page can be composed of other components and static data. The `/src/views/Products.vue` view is the page that uses the `/src/components/ProductsList.vue` component to display a list of products.

### Adding routes

Next, you'll define a new route in `/src/router/index.js`. This route loads the Products view when someone visits the root of the application, `/`:

```js
import Vue from 'vue';
import VueRouter from 'vue-router';
import Products from '@/views/Products';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'products',
    component: Products
  }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router
```

### Router view

You can run this and ask the students why nothing is being displayed. If you look in `App.vue`, there is nothing defined in the template. To display the correct view, you need to include the `<router-view>` component:

```html
<template>
  <router-view />
</template>

<script>
  export default {};
</script>
```

> The `<router-view>` component is a functional component that renders the matched component for the given path.

If you run the application again, you'll see the list of products.

## Product detail

When this next step is complete, you'll be able to click the product name from the list of products to view the product detail page. This page shows product details and a list of reviews. You need to update the `ProductsList` to link to the `ProductDetail` page, but before you do that, you'll need to create a new route and view.

### Product detail route

First, you'll add a new route in `/src/router/index.js`. This is a dynamic route that a user can visit. Below are some examples:

- /products/1
- /products/2
- /products/3

This might be a good time to walk through the mechanics of creating a dynamic route. The `ProductDetail` view doesn't exist yet, but you'll create it in the next step:

```js
import Vue from 'vue';
import VueRouter from 'vue-router';
import Products from '@/views/Products';
import ProductDetail from '@/views/ProductDetail';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'products',
    component: Products
  },
  {
    path: '/products/:id',
    name: 'product-detail',
    component: ProductDetail
  }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router
```

> A dynamic segment is denoted by a colon `:`. When a route is matched, the value of the dynamic segments is exposed as `this.$route.params` in every component.

### Product detail view

With the route created, you need to create a new view: `/src/views/ProductDetail.vue`. The first thing to do is to set the active product in the store. This allows any component in your application to ask what the current product is and get back the product ID. You can do this by accessing the params from the `this.$route` object:

```js
export default {
    created() {
        const activeProductID = this.$route.params.id;
        this.$store.commit("SET_ACTIVE_PRODUCT", activeProductID);
    }
}
```

You should briefly explain the `created()` method is a Vue Lifecycle Hook. Hooks are explained in greater detail during the JavaScript Web Services day.

For now, it should be enough for students to understand the code inside the method is executed each time a new instance of `ProductDetail` is created.

Now that you know the active product, you can create a computed property that retrieves that product from the store:

```js
computed: {
  product() {
    return this.$store.state.products.find(
      (p) => {
        return p.id == this.$store.state.activeProduct;
      }
    );
  }
}
```

The rest of this component reconstructs what was in `App.vue` from a previous lecture. This is a good time to explain that a view is just a component that can consist of data and other components:

```html
<template>
  <div id="app" class="main">
    <h1>{{ product.name }}</h1>
    <p class="description">{{ product.description }}</p>
    <div class="actions">
      <a href="#">Back to Products</a>&nbsp;|
      <a href="#">Add Review</a>
    </div>
    <div class="well-display">
      <average-summary />
      <star-summary rating="1" />
      <star-summary rating="2" />
      <star-summary rating="3" />
      <star-summary rating="4" />
      <star-summary rating="5" />
    </div>
    <review-list />
  </div>
</template>

<script>
  import AverageSummary from '@/components/AverageSummary';
  import StarSummary from '@/components/StarSummary';
  import ReviewList from '@/components/ReviewList.vue';

  export default {
    name: 'product-detail',
    components: {
      AverageSummary,
      StarSummary,
      ReviewList
    },
    computed: {
      product() {
        return this.$store.state.products.find(
          (p) => {
            return p.id == this.$store.state.activeProduct;
          }
        );
      }
    },
    /*
    created is a Vue Lifecycle Hook, which is explained in greater detail in the JavaScript Web Services topic.
    For now, it should be enough to understand the code inside the method is executed each time a new instance of ProductDetail is created.
    */
    created() {
      const activeProductID = this.$route.params.id;
      this.$store.commit('SET_ACTIVE_PRODUCT', activeProductID);
    }
  };
</script>
```

You can test this out by manually navigating to a URL like `/products/1`. In the next section, you'll add links to the `ProductsList` page so you can click through to the detail page.

### Router links

If you look at the list of products (`src/components/ProductsList.vue`), there's no way to click through to each product to see the list of reviews. You need to make the product name clickable, and it should go to `/products/:id`, so add a `<router-link>` tag around the product name:

```html
<template>
  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th># Reviews</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="product in $store.state.products" v-bind:key="product.id">
        <td>{{ product.id }}</td>
        <td>
          <router-link
            v-bind:to="{ name: 'product-detail', params: { id: product.id }}">
            {{ product.name }}
          </router-link>
        </td>
        <td>{{ product.reviews.length }}</td>
      </tr>
    </tbody>
  </table>
</template>
```

In `/src/views/ProductDetail.vue`, update the `Back to Products` link to use `<router-link>`:

```html
<div class="actions">
  <a href="#">Back to Products</a>&nbsp;|
  <a href="#">Add Review</a>
</div>
```

You might be tempted to do something like this:

```html
<div class="actions">
  <router-link to="/">Back to Products</router-link>&nbsp;|
  <a href="#">Add Review</a>
</div>
```

But this is a good time—if you haven't already—to point out why using named routes is preferred. If the path for the `ProductsList` changes to `/products` in the future, and you hard-coded `/` everywhere, you'd need to go through and update each of those links. With named routes, you don't have to worry about that:

```html
<div class="actions">
  <router-link v-bind:to="{ name: 'products' }">Back to Products</router-link>&nbsp;|
  <a href="#">Add Review</a>
</div>
```

## Add new review

The last feature in this application is to take the add review form from the previous lecture that was inline and move it into a view.

First, update the router configuration that allows you to create a new product review. The path includes the product ID, so the add review form knows what product you're adding a review to:

```js
import Vue from 'vue';
import VueRouter from 'vue-router';
import Products from '@/views/Products';
import ProductDetail from '@/views/ProductDetail';
import AddReview from '@/views/AddReview';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'products',
    component: Products
  },
  {
    path: '/product/:id',
    name: 'product-detail',
    component: ProductDetail
  },
  {
    path: '/product/:id/add-review',
    name: 'add-review',
    component: AddReview
  }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router
```

Next, create the add review form `/src/views/AddReview.vue`. This view imports the `AddReview` component, which is responsible for creating a new review and committing the mutation to the store:

```html
<template>
  <div>
    <h1>Add Review</h1>
    <add-review />
  </div>
</template>

<script>
  import AddReview from '@/components/AddReview';

  export default {
    components: {
      AddReview
    }
  };
</script>
```

If you open `/src/components/AddReview.vue`, there is a line of code that you need to write during the lecture:

```js
methods: {
  addNewReview() {
    const productID = this.$route.params.id;
    this.newReview.productID = productID;
    this.$store.commit("ADD_REVIEW", this.newReview);
    // TODO: send the visitor back to the product page to see the new review
  },
  resetForm() {
    this.newReview = {};
  }
}
```

Ask the students if they know a way to programmatically send the user to the product detail page after a new review is added:

```js
this.$router.push({ name: 'product-detail', params: { id: productID } });
```

Finally, update the Add Review link in `/src/views/ProductDetail.vue`:

```html
<div class="actions">
  <router-link v-bind:to="{ name: 'products' }">Back to Products</router-link>&nbsp;|
  <router-link v-bind:to="{ name: 'add-review', params: { id: product.id } }">
    Add Review
  </router-link>
</div>
```

