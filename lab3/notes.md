## Interface vs Abstract class
Interfaces are generally used to unify some set of operations over set of somewhat different abstractions. 

### Interfaces

- Define well known public contract, *abilities* of the type (what operations can be performed on an object)
- Applicable to show horizontal inheritance, i.e. branching on the first level of inheritance (e.g. ILog to define logging facilities to database, text file, XML, SOAP etc.)
- Useful for third party integration
- Don't care about underlying type at all (unless satisfy interface constraints)


### Abstract class

- Define structure, *identity* and some default supported behaviour
- Applicable to show vertical inheritance, i.e. deep branching on the several levels

As a conclusion: use abstract classes when you need to demonstrate that object *is* something. Use interfaces if don't care about underlying implementation (for you it does not matter from which particular class this one is inherited) and just interested in the interface part

We may think of abstract classes as if they define *main* kind of objects, while interfaces defines peripheral properties (secondary kinds).

<hl>

So, in my opinion `Store` should be an abstract class. It defines a kind of derivative subclasses (stores may be different like for liquids or for raw material or for general items. But all in all they all are stores.). By inheriting `Inventory` form `Store` we show, that inventory is `Store`.

But `Storable` should be an interface, because it is not a main characteristic (property, feature) of a class. `Item`, `RawResource` are different, separate things and are *not* `Storable`s in the first place. `Storable` is their additional feature. So when `RawResource` implements `Storable` we means that is has capability of been stored.
