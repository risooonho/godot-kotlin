package godot.core

internal class IndexedIterator<T>(
    private var size: () -> Int,
    private val getter: (Int) -> T,
    private val eraser: (Int) -> Unit
) : MutableIterator<T> {
    private var index = 0
    private var length = size()

    override fun hasNext(): Boolean {
        return index < length
    }

    override fun next(): T {
        return getter(index++)
    }

    override fun remove() {
        eraser(--index)
        length = size()
    }
}

internal class Entry<K, V>(
    override val key: K,
    private val getter: (K) -> V,
    private val setter: (K, V) -> Unit
) : MutableMap.MutableEntry<K, V> {

    override val value: V
        get() {
            return getter(key)
        }

    override fun setValue(newValue: V): V {
        val ret = value
        setter(key, newValue)
        return ret
    }
}

internal class MapIterator<K : Any, V : Any>(
    private val keyIterator: MutableIterator<K>,
    private val getter: (K) -> V,
    private val setter: (K, V) -> Unit,
    private val eraser: (K) -> Unit
) : MutableIterator<MutableMap.MutableEntry<K, V>> {
    lateinit var key: K

    override fun hasNext(): Boolean {
        return keyIterator.hasNext()
    }

    override fun next(): MutableMap.MutableEntry<K, V> {
        key = keyIterator.next()
        return Entry(key, getter, setter)
    }

    override fun remove() {
        keyIterator.remove()
        eraser(key)
    }
}
