package xyz.beever.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import xyz.beever.demo.dao.PasteRepository;
import xyz.beever.demo.model.Paste;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

