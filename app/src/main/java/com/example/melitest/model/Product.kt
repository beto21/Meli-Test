package com.example.melitest.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = Product.TABLE_NAME)
data class Product(
    val accepts_mercadopago: Boolean? = null,
    val available_quantity: Int? = null,
    val buying_mode: String? = null,
    val catalog_listing: Boolean? = null,
    val catalog_product_id: String? = null,
    val category_id: String? = null,
    val condition: String? = null,
    val currency_id: String? = null,
    val domain_id: String? = null,
    @PrimaryKey
    val id: String = "",
    val inventory_id: String? = null,
    val listing_type_id: String? = null,
    val official_store_id: Int? = null,
    val official_store_name: String? = null,
    val order_backend: Int? = null,
    val original_price: Double? = null,
    val permalink: String? = null,
    val price: Double? = null,
    val site_id: String? = null,
    val sold_quantity: Int? = null,
    val stop_time: String? = null,
    val thumbnail: String? = null,
    val thumbnail_id: String? = null,
    val title: String? = null,
    val use_thumbnail_id: Boolean? = null,
) : Parcelable {


    private constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()!!,
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
    }

    companion object CREATOR : Parcelable.Creator<Product> {

        const val TABLE_NAME = "product"

        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}