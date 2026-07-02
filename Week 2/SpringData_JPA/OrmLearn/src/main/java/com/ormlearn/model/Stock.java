package com.ormlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * GROUP 2 — Hands-on 2: Query Methods on Stock Table
 *
 * JPA Entity representing a stock market trading day record.
 *
 * TABLE: stock
 * +-------+----------+----------+---------+---------+-----------+
 * | st_id | st_label | st_date  | st_open |st_close | st_volume |
 * +-------+----------+----------+---------+---------+-----------+
 * | 1     | FB       |2019-09-03| 186.00  | 187.50  | 14500000  |
 * +-------+----------+----------+---------+---------+-----------+
 *
 * QUERY METHODS DEMONSTRATED:
 * 1. findByLabelAndTradeDateBetween    → Facebook in September 2019
 * 2. findByLabelAndClosePriceGreaterThan → Google > 1250
 * 3. findTop3ByOrderByVolumeDesc       → Top 3 highest volume days
 * 4. findTop3ByLabelOrderByClosePriceAsc → Lowest 3 Netflix days
 *
 * HOW SPRING DATA DERIVES SQL:
 * "findByLabelAndTradeDateBetween" →
 *   SELECT * FROM stock
 *   WHERE st_label = ? AND st_date BETWEEN ? AND ?
 */
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private int id;

    /**
     * Stock ticker symbol: "FB", "GOOG", "NFLX"
     * Maps to column st_label
     */
    @Column(name = "st_label", length = 10, nullable = false)
    private String label;

    /**
     * The trading date. LocalDate maps to SQL DATE type.
     */
    @Column(name = "st_date", nullable = false)
    private LocalDate tradeDate;

    /**
     * Opening price for the trading day.
     */
    @Column(name = "st_open")
    private double openPrice;

    /**
     * Closing price for the trading day.
     */
    @Column(name = "st_close")
    private double closePrice;

    /**
     * Total shares traded during the day.
     */
    @Column(name = "st_volume")
    private long volume;

    // ---- Constructors ----
    public Stock() {
    }

    // ---- Getters & Setters ----
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public LocalDate getTradeDate() { return tradeDate; }
    public void setTradeDate(LocalDate tradeDate) { this.tradeDate = tradeDate; }

    public double getOpenPrice() { return openPrice; }
    public void setOpenPrice(double openPrice) { this.openPrice = openPrice; }

    public double getClosePrice() { return closePrice; }
    public void setClosePrice(double closePrice) { this.closePrice = closePrice; }

    public long getVolume() { return volume; }
    public void setVolume(long volume) { this.volume = volume; }

    @Override
    public String toString() {
        return "Stock [label=" + label + ", date=" + tradeDate
                + ", open=" + openPrice + ", close=" + closePrice
                + ", volume=" + volume + "]";
    }
}
