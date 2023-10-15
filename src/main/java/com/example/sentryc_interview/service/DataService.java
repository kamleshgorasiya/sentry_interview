package com.example.sentryc_interview.service;

import com.example.sentryc_interview.entities.Marketplace;
import com.example.sentryc_interview.entities.Producer;
import com.example.sentryc_interview.entities.Seller;
import com.example.sentryc_interview.entities.SellerInfo;
import com.example.sentryc_interview.enums.State;
import com.example.sentryc_interview.repository.MarketPlacesRepository;
import com.example.sentryc_interview.repository.ProducersRepository;
import com.example.sentryc_interview.repository.SellerInfoRepository;
import com.example.sentryc_interview.repository.SellersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DataService {

    private static final int NUM_MARKETPLACES = 100;
    private static final int NUM_PRODUCERS = 100;
    private static final int NUM_SELLER_INFOS = 1000;
    private static final int NUM_SELLERS = 1000;

    @Autowired
    private MarketPlacesRepository marketplaceRepository;

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Autowired
    private ProducersRepository producerRepository;

    @Autowired
    private SellersRepository sellerRepository;

    @Transactional
    public void generateAndSaveData() {

        // Create Marketplaces
        List<Marketplace> marketplaces = new ArrayList<>();
        String[] marketplaceNames = {"Amazon", "Ebay", "Aliexpress", "Walmart", "Target", "BestBuy", "Shopify", "Rakuten"};
        for (int i = 0; i < NUM_MARKETPLACES; i++) {
            Marketplace m = new Marketplace();
            m.setId("marketplace" + (i + 1));
            m.setDescription(marketplaceNames[i % marketplaceNames.length] + " Description");
            marketplaces.add(m);
        }
        List<Marketplace> savedMarketplaces = marketplaceRepository.saveAll(marketplaces);

        // Create Producers
        List<Producer> producers = new ArrayList<>();
        String[] producerNames = {"Adidas", "Nike", "Puma", "Reebok", "Under Armour", "Converse", "New Balance", "Asics"};
        for (int i = 0; i < NUM_PRODUCERS; i++) {
            Producer p = new Producer();
            p.setId(UUID.randomUUID());
            p.setName(producerNames[i % producerNames.length] + (i / producerNames.length));
            p.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            producers.add(p);
        }
        List<Producer> producers1 = producerRepository.saveAll(producers);

        // Create SellerInfos
        List<SellerInfo> sellerInfos = new ArrayList<>();
        for (int i = 0; i < NUM_SELLER_INFOS; i++) {
            SellerInfo si = new SellerInfo();
            si.setId(UUID.randomUUID());
            si.setMarketplace(savedMarketplaces.get(i % marketplaces.size()));
            si.setName("Reseller" + (i + 1));
            si.setUrl("http://reseller" + (i + 1) + ".com");
            si.setCountry("US");
            si.setExternalId("external" + (i + 1));
            sellerInfos.add(si);
        }
        List<SellerInfo> sellerInfos1 = sellerInfoRepository.saveAll(sellerInfos);

        // Create Sellers
        State[] states = State.values();
        for (int i = 0; i < NUM_SELLERS; i++) {
            Seller s = new Seller();
            s.setId(UUID.randomUUID());
            s.setProducer(producers1.get(i % producers1.size()));
            s.setSellerInfo(sellerInfos1.get(i));
            s.setState(states[i % states.length]);
            sellerRepository.save(s);
        }
    }
}
