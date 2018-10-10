# Info

Small project demonstrating a hanging issue with Carmine as of 2.19.0.

## Behaviour

Java does not exit your program if you use carmine.

## Demo

Run `lein run` and see the program hang.

Removing the carmine command in `core.clj`, or downgrading to 2.18.2 will make it work again.

## Hypothesis

Something in the upgraded Apache Pool library is causing it to hang. (Introduced here: https://github.com/ptaoussanis/carmine/commit/b850ebb6b610de995d0885efbc067bfc18f0bae8)

## Notes

- So far tested on my local machine on Java 8, 9 and 10.
- Have pin pointed it down to the connection pool. Using a `:none` pool makes it work again, as does downgrading `commons-pool2`.
